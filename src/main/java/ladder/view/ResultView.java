package ladder.view;

import ladder.domain.*;

public class ResultView {

    private static final String MESSAGE_RESULT = "사다리 결과";
    private static final String MESSAGE_SELECT_USER = "결과를 보고 싶은 사람은? (quit 입력 시 종료됩니다.)";
    private static final String REWARD_RESULT_MESSAGE = "실행 결과";
    private static final String END_GAME_MESSAGE = "게임을 종료하겠습니다.";
    private static final String ALL_USERS = "all";
    private static final String NONE_USER = "해당하는 유저가 없습니다.";
    private static final String END_GAME = "quit";
    private static final String REWARD_OF_USER = "%s : %s";
    private static final String FIELD = "%5s ";
    private static final String CONNECTION = "-----";
    private static final String DISCONNECTION = "     ";
    private static final String SINGLE_POINT = "|";

    public static void printLadder(LadderGame ladderGame, LadderRewards ladderRewards) {
        System.out.println(MESSAGE_RESULT);

        ladderGame.getUnmodifiableUsers().forEach(user -> System.out.printf(FIELD , user.name()));
        System.out.println();

        ladderGame.getUnmodifiableLadderLines().forEach(ResultView::printLadderLines);
        ladderRewards.ladderRewards().forEach(ladderReward -> System.out.printf(FIELD, ladderReward.reward()));
        System.out.println();
    }

    public static void showResult(LadderGameResult ladderResult) {
        boolean continueGame = true;

        while (continueGame) {
            System.out.println(MESSAGE_SELECT_USER);
            String userName = InputView.inputUserName();

            continueGame = isContinueGame(userName);

            showResultReward(userName, ladderResult);
        }
    }

    private static void printLadderLines(Line ladderLine) {
        ladderLine.getUnmodifiableListPoints().forEach(point -> System.out.print(connection(point.canMovePrevious()) + SINGLE_POINT));
        System.out.println();
    }

    private static String connection(boolean movable) {
        if (movable) {
            return CONNECTION;
        }
        return DISCONNECTION;
    }

    private static void showResultReward(String userName, LadderGameResult ladderResult) {
        if (isContinueGame(userName) == false) {
            System.out.println(END_GAME_MESSAGE);
            return;
        }

        if (userName.equals(ALL_USERS)) {
            System.out.println(REWARD_RESULT_MESSAGE);
            printUserAndReward(ladderResult);
            return;
        }

        System.out.println(REWARD_RESULT_MESSAGE);
        System.out.println(rewardStatus(ladderResult.rewardOfUser(userName)));
    }

    private static boolean isContinueGame(String userName) {
        return !userName.equalsIgnoreCase(END_GAME);
    }

    private static void printUserAndReward(LadderGameResult ladderResult) {
        ladderResult.users().forEach(user -> {
            System.out.printf(REWARD_OF_USER, user.name(), rewardStatus(ladderResult.rewardOfUser(user.name())));
            System.out.println();
        });
    }

    private static String rewardStatus(Reward ladderReward) {
        if (ladderReward == null) {
            return NONE_USER;
        }
        return ladderReward.reward();
    }

}
