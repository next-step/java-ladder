package nextstep.ladder.view;

import nextstep.ladder.domain.*;

import static nextstep.ladder.util.Validation.INPUT_ALL;
import static nextstep.ladder.util.Validation.isContainPlayer;


public class ResultView {
    private static final String EMPTY_LINE = "     |";
    private static final String HORIZONTAL_LINE = "-----|";
    private static final String LADDER_MESSAGE = "사다리 결과";
    private static final String RESULT_MESSAGE = "실행 결과";
    private static final String FORMAT_SIZE = "%6s";

    public static void printLadderGame(Players players, Ladder ladder) {
        System.out.println(LADDER_MESSAGE);
        players.stream()
                .map(ResultView::toFormat)
                .forEach(System.out::print);

        ladder.stream()
                .forEach(ResultView::drawLine);
    }

    private static void drawLine(LadderLine line) {
        System.out.println();
        line.stream()
                .map(ResultView::isHorizontalLine)
                .forEach(System.out::print);
    }

    private static String toFormat(Name name) {
        return String.format(FORMAT_SIZE, name);
    }

    private static String isHorizontalLine(Point point) {
        if (point.isCurrent()) {
            return HORIZONTAL_LINE;
        }
        return EMPTY_LINE;
    }

    public static void printResultGroup(Result result) {
        System.out.println();
        result.stream()
                .map(str -> String.format(FORMAT_SIZE, str))
                .forEach(System.out::print);
        System.out.println();

    }

    public static void printLadderGameResult(Players players, Result result) {
        int index = 0;
        while (index != INPUT_ALL) {
            String findPlayerResult = InputView.inputGameResultSearch();
            System.out.println(RESULT_MESSAGE);
            index = isContainPlayer(findPlayerResult, players);
            printLadderGameAllOrNot(index, players, result);
        }
    }

    public static void printLadderGameAllOrNot(int index, Players players, Result result) {
        if (index == INPUT_ALL) {
            printLadderGameAll(players, result);
            return;
        }
        System.out.println(result.get(index));
    }

    private static void printLadderGameAll(Players players, Result result) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < players.size(); i++) {
            sb.append(players.name(i)).append(" : ");
            sb.append(result.get(i)).append("\n");
        }
        System.out.println(sb);
    }
}
