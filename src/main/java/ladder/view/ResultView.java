package ladder.view;

import ladder.domain.Ladder;
import ladder.domain.LadderLine;
import ladder.domain.LadderMembers;

import java.util.stream.Collectors;

public class ResultView {
    private static final String RESULT = System.lineSeparator() + "======실행결과======" + System.lineSeparator();
    private static final String EXIST_LINE_PART = "-----|";
    private static final String NOT_EXIST_LINE_PART = "     |";

    private ResultView() {
    }

    public static void printLadderResult(LadderMembers members, Ladder ladder) {
        System.out.println(RESULT);
        printMembers(members);
        printLadder(ladder);
    }

    private static void printMembers(LadderMembers members) {
        members.getMembers()
                .forEach(member -> System.out.printf("%5s ", member.name()));
        System.out.println();
    }

    private static void printLadder(Ladder ladder) {
        ladder.lines()
                .stream()
                .map(ResultView::printLines)
                .forEach(System.out::println);
    }

    private static String printLines(LadderLine line) {
        return line.parts()
                .stream()
                .map(ResultView::getPart)
                .collect(Collectors.joining());
    }

    private static String getPart(boolean part) {
        if (part) {
            return EXIST_LINE_PART;
        }
        return NOT_EXIST_LINE_PART;
    }
}
