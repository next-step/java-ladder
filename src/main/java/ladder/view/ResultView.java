package ladder.view;

import ladder.domain.*;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ResultView {
    private static final String LADDER_MESSAGE = "사다리 결과";
    private static final String RESULT_MESSAGE = "실행 결과";
    private static final String SPACE_FIVE = "     ";
    private static final String SPACE_FOUR = "    ";
    private static final String SPACE_ONE = " ";
    private static final String HYPHEN_FIVE = "-----";
    private static final String VERTICAL_LINE = "|";
    private static final String NEXT_LINE = "\n";
    private static final int NAME_SPACE_SIZE = 4;
    private static final String COLON = " : ";

    public static void ladderMessage() {
        System.out.print(NEXT_LINE);
        System.out.println(LADDER_MESSAGE);
    }

    public static void printNames(Names names) {
        int loopNumber = names.size();
        for (int i = 0; i < loopNumber; i++) {
            String name = names.value(i);
            System.out.print(name + spaceSize(name));
        }
        System.out.print(NEXT_LINE);
    }

    private static String spaceSize(String name) {
        if (name.length() < NAME_SPACE_SIZE) {
            return SPACE_FOUR;
        }
        return SPACE_ONE;
    }

    public static void printLadder(Ladder ladder) {
        int loopNumber = ladder.size();
        IntStream.range(0, loopNumber)
                .forEach(i -> System.out.println(ladderLine(ladder.findLine(i))));
    }

    private static String ladderLine(Line line) {
        int ladderLineCount = line.size() - 1;
        return VERTICAL_LINE + IntStream.range(0, ladderLineCount)
                .mapToObj(i -> lineAndEmpty(line.value(i)))
                .collect(Collectors.joining(VERTICAL_LINE)) + VERTICAL_LINE;
    }

    private static String lineAndEmpty(int line) {
        return line == 0 ? SPACE_FIVE : HYPHEN_FIVE;
    }

    public static void printPrizes(Prizes prizes) {
        int loopNumber = prizes.size();
        for (int i = 0; i < loopNumber; i++) {
            String prize = prizes.value(i);
            System.out.print(prize + spaceSize(prize));
        }
        System.out.print(NEXT_LINE);
    }

    public static void printLadderResult(Winning winning, Name name) {
        System.out.print(NEXT_LINE);
        System.out.println(RESULT_MESSAGE);
        if (name.value().equalsIgnoreCase("all")) {
            printPrizesAll(winning);
        }
        System.out.println(winning.prize(name).value());
    }

    private static void printPrizesAll(Winning winning) {
        for (Name name : winning.playerByPrize().keySet()) {
            System.out.println(name.value() + COLON + winning.prize(name).value());
        }
        System.exit(0);
    }

}
