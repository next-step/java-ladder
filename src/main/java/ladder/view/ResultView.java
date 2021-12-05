package ladder.view;

import ladder.domain.Ladder;
import ladder.domain.Line;
import ladder.domain.Names;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ResultView {
    private static final String RESULT_MESSAGE = "실행결과";
    private static final String SPACE_FIVE = "     ";
    private static final String SPACE_FOUR = "    ";
    private static final String SPACE_ONE = " ";
    private static final String HYPHEN_FIVE = "-----";
    private static final String VERTICAL_LINE = "|";
    private static final String NEXT_LINE = "\n";
    private static final int NAME_SPACE_SIZE = 4;

    public static void resultMessage() {
        System.out.println(RESULT_MESSAGE);
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
}
