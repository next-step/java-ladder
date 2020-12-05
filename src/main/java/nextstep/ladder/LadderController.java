package nextstep.ladder;

import nextstep.ladder.entity.User;
import nextstep.ladder.entity.ladder.*;
import nextstep.ladder.view.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class LadderController {

    public void ladderGame() {
        // 사용자 입력 받기
        Users users = getUsers();
        // 실행 결과 입력 받기
        GameResults gameResults = getGameResults();
        // 사다리 높이 입력 받기
        LadderHeight ladderHeight = getLadderHeight();

        // 사다리 생성
        FloorGenerator floorGenerator
                = new FloorGenerator(RandomLinkGenerator.getInstance(), new LadderLine(users.getUserCount()));
        Ladder ladder = Ladder.create(ladderHeight, floorGenerator);

        // 출력
        LadderResultView.display(ladder, users, gameResults);
        // 결과 보기 사용자 입력
        User showGameResultUser = getShowGameResultUser();

        if (Objects.isNull(showGameResultUser)) {
            showAllUsers(ladder, users, gameResults);
            return;
        }

        showSingleUser(ladder, users, showGameResultUser, gameResults);
    }

    private Users getUsers() {
        return new Users(UsersInputView.getUserInput());
    }

    private LadderHeight getLadderHeight() {
        return new LadderHeight(LadderHeightInputView.getLadderHeight());
    }

    private User getShowGameResultUser() {
        String showGameResultUser = ShowGameResultUserInputView.getShowGameResultUser();
        if (showGameResultUser.equals("all")) {
            return null;
        }
        return new User(showGameResultUser);
    }

    private GameResults getGameResults() {
        return new GameResults(GameResultInputView.getGameResult());
    }

    private void showAllUsers(Ladder ladder, Users users, GameResults gameResults) {
        for (int position = 1; position <= users.getUserCount(); position++) {
            int arrivalPosition = ladder.goDown(position);
            gameResults.map(users.at(position), arrivalPosition);
        }
        // 출력
        GameResultView.displayResultWithUserName(users, gameResults);
    }

    private void showSingleUser(Ladder ladder, Users users, User showGameResultUser, GameResults gameResults) {
        // 결과 계산
        int startPosition = users.getPosition(showGameResultUser);
        int arrivalPosition = ladder.goDown(startPosition);

        // 출력
        gameResults.map(users.at(startPosition), arrivalPosition);
        GameResult gameResult = gameResults.getGameResult(arrivalPosition);

        GameResultView.displaySingleResult(gameResult);
    }
}
