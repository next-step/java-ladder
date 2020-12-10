package ladder.view;

import ladder.domain.LadderLine;
import ladder.domain.Ladder;

import java.util.List;
import java.util.stream.IntStream;

public class ResultView {
    public static final String RESULT = "실행결과";
    private static final String BAR = "|";
    private static final String BLANK = "     ";
    private static final String LADDER = "-----";
    private static final int MAX_NAME_SPACE = 6;

    protected static void printResult(Ladder ladder, List<String> participants) {
        printResultHeader();
        printParticipants(participants);
        printLadders(ladder);
    }

    private static void printResultHeader() {
        System.out.println();
        System.out.println(RESULT);
        System.out.println();
    }

    private static void printLadders(Ladder ladder) {
        for (LadderLine ladderLine : ladder.getLadderLines()) {
            printLadderLine(ladderLine);
        }
    }

    private static void printParticipants(List<String> participants) {
        participants.forEach(name -> {
            System.out.print(name);
            printBlank(name);
        });
        System.out.println();
    }

    private static void printBlank(String name) {
        IntStream.range(0, MAX_NAME_SPACE - name.length())
                .forEach(index -> System.out.print(" "));
    }

    private static void printLadderLine(LadderLine ladderLine) {
        IntStream.range(0, ladderLine.getValue().size())
                .mapToObj(index -> getLadder(ladderLine, index))
                .forEach(System.out::print);
        System.out.println();
    }

    private static String getLadder(LadderLine ladderLine, int index) {
        if (isBarIndex(index)) {
            return BAR;
        }
        if (Boolean.TRUE.equals(ladderLine.getValue().get(index))) {
            return LADDER;
        }
        return BLANK;
    }

    private static boolean isBarIndex(int index) {
        return index % 2 == 0;
    }

}
