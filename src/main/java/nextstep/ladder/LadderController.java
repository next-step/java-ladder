package nextstep.ladder;

import nextstep.ladder.entity.User;
import nextstep.ladder.entity.ladder.*;
import nextstep.ladder.view.*;

import java.util.List;
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

        // 결과 계산
        int position = users.getPosition(showGameResultUser);
        int arrivalPosition = ladder.goDown(position);

        // 출력
        String gameResult = gameResults.getGameResult(arrivalPosition);

        System.out.println("실행 결과");
        System.out.println(gameResult);

    }

    private Users getUsers() {
        return new Users(UsersInputView.getUserInput());
    }

    private LadderHeight getLadderHeight() {
        return new LadderHeight(LadderHeightInputView.getLadderHeight());
    }

    private User getShowGameResultUser() {
        String showGameResultUser = ShowGameResultUserInputView.getShowGameResultUser();
        return new User(showGameResultUser);
    }

    private GameResults getGameResults() {
        return new GameResults(GameResultInputView.getGameResult());
    }

}
