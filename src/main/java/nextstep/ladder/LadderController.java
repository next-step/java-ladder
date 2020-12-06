package nextstep.ladder;

import nextstep.ladder.entity.User;
import nextstep.ladder.entity.ladder.*;
import nextstep.ladder.view.*;

public class LadderController {

    private static final String ALL_RESULT = "all";

    public void ladderGame() {
        // 사용자 입력 받기
        Users users = getUsers();
        // 실행 결과 입력 받기
        GameResults gameResults = getGameResults();
        // 사다리 높이 입력 받기
        LadderHeight ladderHeight = getLadderHeight();

        // 사다리 생성
//        Ladder ladder = Ladder.create(ladderHeight, floorGenerator);
//
//        // 사다리 초기화
//        ladder.startWith(users);
//        ladder.arrivalAt(gameResults);
//
//        // 출력
//        LadderResultView.display(ladder, users, gameResults);
//        // 결과 보기 사용자 입력
//        User showGameResultUser = getShowGameResultUser();
//
//        // Single
//        if (!doShowAllUsers(showGameResultUser)) {
//            GameResult gameResult = ladder.goDown(showGameResultUser);
//            GameResultView.displaySingleResult(gameResult);
//        }
//
//        // Multi
//        if (doShowAllUsers(showGameResultUser)) {
//            // 메서드로 이동해야함
//            users.goDownAllUsers(ladder);
//            GameResultView.displayResultWithUserName(users, gameResults);
//        }

    }

    private Users getUsers() {
        return new Users(UsersInputView.getUserInput());
    }

    private LadderHeight getLadderHeight() {
        return new LadderHeight(LadderHeightInputView.getLadderHeight());
    }

    private User getShowGameResultUser() {
        return new User(ShowGameResultUserInputView.getShowGameResultUser());
    }

    private GameResults getGameResults() {
        return new GameResults(GameResultInputView.getGameResult());
    }


    private boolean doShowAllUsers(User user) {
        return ALL_RESULT.equals(user.getName());
    }

}
