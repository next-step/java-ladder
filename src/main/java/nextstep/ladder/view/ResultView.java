package nextstep.ladder.view;

import nextstep.ladder.domain.*;

import static nextstep.ladder.domain.Name.*;

public class ResultView {
    private static final String EMPTY_LINE = "     |";
    private static final String HORIZONTAL_LINE = "-----|";
    private static final String LADDER_MESSAGE = "사다리 결과";
    private static final String RESULT_MESSAGE = "실행 결과";
    private static final String FORMAT_SIZE = "%6s";
    private static final String COLON = " : ";

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

    public static void printLadderGameResult(LadderResult ladderResult) {
        String findPlayerResult = "";
        while (!ALL_RESULT.equals(findPlayerResult)) {
            findPlayerResult = InputView.inputGameResultSearch();
            System.out.println(RESULT_MESSAGE);
            printLadderGameAllOrNot(findPlayerResult, ladderResult);
        }
    }

    private static void printLadderGameAllOrNot(String findPlayerResult, LadderResult ladderResult) {
        if (ALL_RESULT.equals(findPlayerResult)) {
            StringBuilder sb = new StringBuilder();
            ladderResult.ketSet()
                    .stream()
                    .forEach(player ->
                            sb.append(player).append(COLON)
                                    .append(ladderResult.get(player)).append("\n")
                    );
            System.out.println(sb);
            return;
        }
        printContainPlayer(findPlayerResult, ladderResult);

    }

    private static void printContainPlayer(String findPlayerResult, LadderResult ladderResult) {
        if (ladderResult.containPlayer(findPlayerResult)) {
            System.out.println(ladderResult.get(findPlayerResult));
            return;
        }
        System.out.println("참여자들 중 해당 이름이 없습니다. 다시 입력하세요");
    }
}
