package ladder.ui;

import java.util.stream.Collectors;
import ladder.domain.ladder.Ladder;
import ladder.domain.model.LadderGameInfo;
import ladder.domain.point.Point;
import ladder.domain.result.ResultPrize;
import ladder.domain.user.User;
import ladder.domain.user.Users;

public class OutputView {

    public static final String RESULT_ALL_KEYWORD = "all";
    private static final String PLAY_RESULT_MESSAGE = "실행결과";
    private static final String PREPARED_RESULT_MESSAGE = "사다리 결과";
    private static final String FIVE_LENGTH_SPACE = "     ";
    private static final String FIVE_LENGTH_HYPHEN = "-----";
    private static final String POINT_INDICATOR = "|";
    private static final int NAME_START_INDEX = 0;
    private static final String DELIMITER = " ";

    private OutputView() {
    }

    public static void printPreparedGame(LadderGameInfo ladderGameInfo, Ladder ladder) {
        System.out.println(PREPARED_RESULT_MESSAGE);
        printUsersNames(ladderGameInfo.getUsers());
        printLadder(ladder);
        printPreparedResult(ladderGameInfo.getResultPrize());

    }

    public static void printLadderGameResult(String name, LadderGameInfo ladderGameInfo, Ladder ladder) {
        System.out.println(PLAY_RESULT_MESSAGE);
        if (RESULT_ALL_KEYWORD.equals(name)) {
            printAllResult(ladderGameInfo, ladder);
            return;
        }
        printResultByName(name, ladderGameInfo, ladder);
    }

    private static void printResultByName(String name, LadderGameInfo ladderGameInfo, Ladder ladder) {
        System.out.println(ladderGameInfo.getResultPrize().getResultByResultPosition(ladderGameInfo.getResultPositionByName(name, ladder)));
    }

    private static void printAllResult(LadderGameInfo ladderGameInfo, Ladder ladder) {
        System.out.println(ladderGameInfo.getAllResultPosition(ladder));
    }

    private static void printUsersNames(Users users) {
        String participantsNames = users.getUsers()
            .stream()
            .map(User::getName)
            .map(OutputView::padToSameLength)
            .collect(Collectors.joining(DELIMITER));
        System.out.println(participantsNames);
    }

    private static void printLadder(Ladder ladder) {
        String ladderShape = ladder.getLines()
            .stream()
            .map(line -> line.getPoints().stream()
                .map(OutputView::transformPointToString)
                .collect(Collectors.joining())
            )
            .collect(Collectors.joining(System.lineSeparator()));
        System.out.println(ladderShape);
    }

    private static void printPreparedResult(ResultPrize resultPrize) {
        String resultsString = resultPrize.getResultPrizeNames()
            .stream()
            .map(OutputView::padToSameLength)
            .collect(Collectors.joining(DELIMITER));
        System.out.println(resultsString);
    }

    private static String transformPointToString(Point point) {
        return POINT_INDICATOR + appendSymbol(point);
    }

    private static String appendSymbol(Point point) {
        if (point.isRightDirection()) {
            return FIVE_LENGTH_HYPHEN;
        }
        return FIVE_LENGTH_SPACE;
    }

    private static String padToSameLength(String name) {
        StringBuilder stringBuilder = new StringBuilder(FIVE_LENGTH_SPACE);
        stringBuilder.replace(NAME_START_INDEX, name.length(), name);
        return stringBuilder.toString();
    }
}
