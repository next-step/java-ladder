package nextstep.ladder.view;

import nextstep.ladder.domain.*;


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
        return String.format(FORMAT_SIZE, name.toString());
    }

    private static String isHorizontalLine(Point point) {
        if (point.currentPoint()) {
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

    public static void printAllResult(Players players, Ladder ladder, Result result) {
        System.out.println();
        System.out.println(RESULT_MESSAGE);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < players.size(); i++) {
            stringBuilder.append(players.name(i) + " : ");
            int index = ladder.search(i);
            stringBuilder.append(result.get(index)).append("\n");
        }
        System.out.println(stringBuilder);
    }

    public static void printPlayerResult(String player) {
        System.out.println();
        System.out.println(RESULT_MESSAGE);
        System.out.println(player);
        System.out.println();

    }
}
