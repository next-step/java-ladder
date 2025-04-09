package ladder.views;

import ladder.domain.*;

import java.util.stream.IntStream;

public class ResultView {

    public static final String LADDER_SEPARATOR = "|";
    public static final int SEGMENT_COUNT = 5;

    public static void printResult(Ladder ladder, LadderGame ladderGame) {
        System.out.println(System.lineSeparator());
        System.out.println("실행결과");

        ResultView.printPlayer(ladderGame.players());
        ResultView.printLadder(ladder);
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
        return nameAtIndex + " ".repeat(SEGMENT_COUNT - nameAtIndex.length());
    }

    private static String getLine(LadderLine ladderLine, int index) {
        String lineSegment = ladderLine.getPoint(index) ? "-" : " ";
        return lineSegment.repeat(SEGMENT_COUNT) + LADDER_SEPARATOR;
    }
}
