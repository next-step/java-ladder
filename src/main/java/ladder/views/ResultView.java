package ladder.views;

import ladder.domain.*;

import java.util.List;
import java.util.stream.IntStream;

public class ResultView {

    public static final String LADDER_SEPARATOR = "|";
    public static final int SEGMENT_COUNT = 5;

    public static void printLadderGame(Ladder ladder, LadderGame ladderGame) {
        System.out.println();
        System.out.println("실행결과");

        ResultView.printPlayer(ladderGame.players());
        ResultView.printLadder(ladder);
        ResultView.printResults(ladderGame.getResults());
    }

    private static void printResults(List<String> results) {
        StringBuilder sb = new StringBuilder();
        results.stream().map(ResultView::getStringWithSpace)
                .forEachOrdered(sb::append);
        System.out.println(sb);
    }

    public static void printPlayer(Players players) {
        StringBuilder sb = new StringBuilder();
        IntStream.range(0, players.count())
                .mapToObj(i -> getNameWithSpace(players.getPlayerAtIndex(i)))
                .forEachOrdered(sb::append);
        System.out.println(sb);
    }

    public static void printLadder(Ladder ladder) {
        ladder.getLadderLinesCopy().forEach(ResultView::printLadderLine);
    }

    private static void printLadderLine(LadderLine ladderLine) {
        StringBuilder sb = new StringBuilder();
        sb.append(LADDER_SEPARATOR);
        IntStream.range(0, ladderLine.size())
                .mapToObj(i -> getLine(ladderLine, i))
                .forEachOrdered(sb::append);
        System.out.println(sb);
    }

    private static String getNameWithSpace(Player playerAtIndex) {
        String nameAtIndex = playerAtIndex.name();
        return getStringWithSpace(nameAtIndex);
    }

    private static String getStringWithSpace(String nameAtIndex) {
        return nameAtIndex + " ".repeat(SEGMENT_COUNT - nameAtIndex.length() + 1);
    }

    private static String getLine(LadderLine ladderLine, int index) {
        String lineSegment = ladderLine.getPoint(index) ? "-" : " ";
        return lineSegment.repeat(SEGMENT_COUNT) + LADDER_SEPARATOR;
    }

    public static void printResultForTarget(LadderGameResult gameResult, String target) {
        if (target.equals("!")) {
            return;
        }

        try {
            System.out.println(renderResult(gameResult, target));
        } catch (IllegalArgumentException e) {
            System.out.println("올바르지 않은 입력입니다.");
        }
    }

    private static String renderResult(LadderGameResult gameResult, String target) {
        StringBuilder sb = new StringBuilder();

        sb.append(System.lineSeparator());
        sb.append("실행 결과");
        sb.append(System.lineSeparator());

        if (target.equals("all")) {
            sb.append(renderResultForAll(gameResult));
            return sb.toString();
        }

        String result = gameResult.getResultFor(target);
        sb.append(result);

        return sb.toString();
    }

    private static StringBuilder renderResultForAll(LadderGameResult gameResult) {
        StringBuilder sb = new StringBuilder();
        gameResult.getResultForAll()
                .forEach((name, result) -> sb.append(renderResultForEach(name, result)));
        return sb;
    }

    private static StringBuilder renderResultForEach(String name, String result) {
        StringBuilder sb = new StringBuilder();
        return sb.append(name)
                .append(" : ")
                .append(result)
                .append(System.lineSeparator());
    }
}
