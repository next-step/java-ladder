package nextstep.ladder.view;

import nextstep.ladder.model.*;

import java.util.stream.Collectors;

/**
 * View이기 때문에 모델을 받아와서, 모델에 위임하기 않고, View 내부에서 출력 로직을 구현하였습니다.
 */
public final class OutputView {
    private static final String RESULT_FOR_LADDER_OUTPUT_MESSAGE = "\n사다리 결과\n";
    private static final String RESULT_FOR_USERS_OUTPUT_MESSAGE = "\n실행 결과";
    private static final String LADDER_HORIZONTAL_BAR = "─";
    private static final String LADDER_VERTICAL_BAR = "┃";
    private static final String BLANK = " ";
    private static final int TEXT_WIDTH = 5;
    private static final String LADDER_OUTPUT_FORMAT = "%6s";
    private static final String EXECUTION_RESULT_FORMAT = "%s : %s";

    private OutputView() {
    }

    public static void printLadderResult(Users users, Ladder ladder, LadderResults ladderResults) {
        System.out.printf("%s%n%s%n%s%n%s%n",
                RESULT_FOR_LADDER_OUTPUT_MESSAGE,
                formattedUserNames(users),
                formattedLadder(ladder),
                formattedLadderResults(ladderResults)
        );
    }

    public static void printExecutionResultForUsers(UserResults userResults, String command) {
        System.out.printf("%s%n%s%n",
                RESULT_FOR_USERS_OUTPUT_MESSAGE,
                formattedUserResults(command, userResults)
        );
    }

        if (command.isAll()) {
            return formattedAllUserResults(userResults);
        }
        return formattedTargetUserResult(userResults, command);
    }

    private static String formattedUserNames(Users users) {
        return users.getUsers()
                .stream()
                .map(OutputView::eachUserName)
                .collect(Collectors.joining());
    }

    private static String formattedLadder(Ladder ladder) {
        return ladder.getLadderLines()
                .stream()
                .map(OutputView::ladderLine)
                .collect(Collectors.joining("\n"));
    }

    private static String formattedLadderResults(LadderResults ladderResults) {
        return ladderResults(ladderResults);
    }

    private static String formattedAllUserResults(UserResults userResults) {
        return userResults.getUserResults()
                .stream()
                .map(OutputView::eachUserResult)
                .collect(Collectors.joining("\n"));
    }

    private static String targetUserResult(UserResults userResults, String command) {
        return userResults.getUserResults()
                .stream()
                .filter(userResult -> userResult.userName().equals(command))
                .map(OutputView::eachUserResult)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(String.format("입력된 참여자이름(%s)는 없습니다.", command)));
    }

    private static String eachUserResult(UserResult v) {
        return String.format(EXECUTION_RESULT_FORMAT, v.userName(), v.ladderResult());
    }

    private static String ladderResults(LadderResults ladderResults) {
        return ladderResults.getLadderResults()
                .stream()
                .map(OutputView::eachLadderResult)
                .collect(Collectors.joining());
    }

    private static String eachLadderResult(LadderResult ladderResult) {
        return ladderOutput(ladderResult.getValue());
    }

    private static String eachUserName(User user) {
        return ladderOutput(user.getName());
    }

    private static String ladderOutput(String name) {
        return String.format(LADDER_OUTPUT_FORMAT, name);
    }

    private static String ladderLine(LadderLine ladderLine) {
        return ladderLine.getPoints()
                .stream()
                .map(OutputView::eachPointDirection)
                .collect(Collectors.joining());
    }

    private static String eachPointDirection(LadderPoint ladderPoint) {
        if (ladderPoint.isLeft()) {
            return new String(new char[TEXT_WIDTH]).replace("\0", LADDER_HORIZONTAL_BAR) + LADDER_VERTICAL_BAR;
        }
        return new String(new char[TEXT_WIDTH]).replace("\0", BLANK) + LADDER_VERTICAL_BAR;
    }
}
