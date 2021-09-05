package nextstep.ladder.view;

import nextstep.ladder.domain.*;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

import static nextstep.ladder.util.Validation.INPUT_ALL;
import static nextstep.ladder.util.Validation.isContainPlayer;


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

    public static void printLadderGameResult(LadderResult gameResult) {
        String findPlayerResult = "";
        while (!"all".equals(findPlayerResult)) {
            findPlayerResult = InputView.inputGameResultSearch();
            System.out.println(RESULT_MESSAGE);
            if (!gameResult.containPlayer(findPlayerResult)) {
                System.out.println("참여자들 중 해당 이름이 없습니다. 다시 입력하세요");
            }


        }
    }

    private static void printLadderGameAllOrNot(String findPlayerResult, LadderResult ladderResult) {
        if ("all".equals(findPlayerResult)) {
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
