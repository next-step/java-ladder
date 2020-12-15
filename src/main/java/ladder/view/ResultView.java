package ladder.view;

import ladder.domain.Ladder;
import ladder.domain.LadderGameInformation;
import ladder.domain.LadderGameResult;
import ladder.domain.LadderLine;

import java.util.List;
import java.util.stream.IntStream;

public class ResultView {
    public static final String RESULT = "실행결과";
    private static final String BAR = "|";
    private static final String SPACE = " ";
    private static final String BLANK = "     ";
    private static final String LADDER = "-----";
    private static final int MAX_NAME_SPACE = 6;

    protected static void printLadders(LadderGameInformation ladder, LadderGameResult participants) {
        printResultHeader();
        printLadderGameResult(ladder, participants);
    }

    private static void printResultHeader() {
        printOpeningLetter();
        System.out.println(RESULT);
        printOpeningLetter();
    }

    private static void printLadderGameResult(LadderGameInformation ladderGameInformation, LadderGameResult results) {
        printLadderGameInformation(ladderGameInformation.getParticipants());
        int firstNameSpace = ladderGameInformation.getParticipants().get(0).length() - 1;
        printLadders(results.getLadder(), firstNameSpace);
        printLadderGameInformation(ladderGameInformation.getResults());
    }

    private static void printLadderGameInformation(List<String> participants) {
        printName(participants.get(0), 0);

        IntStream.range(1, participants.size())
                .forEach(index -> printName(participants.get(index), MAX_NAME_SPACE - participants.get(index).length()));
        printOpeningLetter();
    }

    private static void printName(String name, int space) {
        printSpace(space);
        System.out.print(name);
    }

    private static void printSpace(int length) {
        IntStream.range(0, length)
                .forEach(index -> System.out.print(SPACE));
    }

    private static void printOpeningLetter() {
        System.out.println();
    }

    private static void printLadders(Ladder ladder, int space) {
        ladder.getLadderLines()
                .forEach(ladderLine -> {
                    printSpace(space);
                    printLadderLine(ladderLine);
                });
    }

    private static void printLadderLine(LadderLine ladderLine) {
        IntStream.range(0, ladderLine.getPoints().size())
                .mapToObj(index -> getLadder(ladderLine, index))
                .forEach(System.out::print);
        printOpeningLetter();
    }

    private static String getLadder(LadderLine ladderLine, int index) {
        if (isBarIndex(index)) {
            return BAR;
        }
        if (Boolean.TRUE.equals(ladderLine.getPoints().get(index))) {
            return LADDER;
        }
        return BLANK;
    }

    private static boolean isBarIndex(int index) {
        return index % 2 == 0;
    }

}
