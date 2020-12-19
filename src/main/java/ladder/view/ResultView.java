package ladder.view;

import ladder.domain.*;

import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class ResultView {
    private static final String SELECT_ALL = "all";
    private static final String NOT_EXISTS_NAME = "Not exists name";
    private static final String RESULT = "실행결과";
    private static final String BAR = "|";
    private static final String SPACE = " ";
    private static final String BLANK = "     ";
    private static final String LADDER = "-----";
    private static final int MAX_NAME_SPACE = 6;

    protected static void printLadders(Ladder ladder, LadderGameResult participants) {
        printResultHeader();
        printLadderGame(ladder, participants);
    }

    private static void printResultHeader() {
        printOpeningLetter();
        System.out.println(RESULT);
        printOpeningLetter();
    }

    private static void printLadderGame(Ladder ladder, LadderGameResult results) {
        printLadderGameParticipants(results.getParticipants());
        int firstNameSpace = results.getParticipants().get(0).length() - 1;
        printLadders(ladder, firstNameSpace);
        printLadderGameResult(results.getEnteredResult(), firstNameSpace);
    }

    private static void printLadderGameParticipants(List<String> participants) {
        printName(participants.get(0), 0);

        IntStream.range(1, participants.size())
                .forEach(index -> printName(participants.get(index), MAX_NAME_SPACE - participants.get(index).length()));
        printOpeningLetter();

    }

    private static void printLadderGameResult(List<String> results, int firstNameSpace) {
        printName(results.get(0), firstNameSpace);

        IntStream.range(1, results.size())
                .forEach(index -> printName(results.get(index), MAX_NAME_SPACE - results.get(index).length()));
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
                    printOpeningLetter();
                });
    }

    private static void printLadderLine(LadderLine ladderLine) {
        ladderLine.getPoints().forEach(ResultView::getLadder);
    }

    private static void getLadder(Point point) {
        System.out.print(BAR);
        if (Boolean.TRUE.equals(point.getDirection().isRight())) {
            System.out.print(LADDER);
            return;
        }
        System.out.print(BLANK);

    }

    protected static void printResult(Map<String, String> ladderGameResult) {
        String name = "";
        while (!name.equals(SELECT_ALL)) {
            name = LadderGameView.enterParticipantName();
            printGameResult(name, ladderGameResult);
        }
    }

    private static void printGameResult(String name, Map<String, String> ladderGameResult) {
        if (ladderGameResult.containsKey(name)) {
            System.out.println();
            System.out.println(RESULT);
            System.out.println(ladderGameResult.get(name));
            return;
        }

        if (name.equals(SELECT_ALL)) {
            System.out.println();
            System.out.println(RESULT);
            ladderGameResult.forEach((key, value) ->
                    System.out.println(key + " : " + value)
            );
            return;
        }

        throw new IllegalArgumentException(NOT_EXISTS_NAME);
    }

}
