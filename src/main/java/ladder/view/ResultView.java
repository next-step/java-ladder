package ladder.view;

import ladder.dto.*;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {
    private static final String LINE_SEPARATOR = System.lineSeparator();
    private static final String LADDER_CREATION = LINE_SEPARATOR + "============사다리 결과============" + LINE_SEPARATOR;
    private static final String EXIST_LINE_PART = "-----|";
    private static final String NOT_EXIST_LINE_PART = "     |";
    private static final String RESULT = LINE_SEPARATOR + "============실행 결과============" + LINE_SEPARATOR;
    private static final String MEMBER_RESULT_MESSAGE = "멤버이름 = %-5s :: 결과 %-5s" + LINE_SEPARATOR;

    private ResultView() {
    }

    public static void printLadderCreation(MembersDto members, LadderDto ladder, List<String> ladderResults) {
        System.out.println(LADDER_CREATION);
        printMembers(members);
        printLadder(ladder);
        printResult(ladderResults);
    }

    public static void printLadderResult(String resultMember, ResultsDto resultsDto) {
        System.out.println(RESULT);
        if(resultMember.equals("all")) {
            resultsDto.values()
                    .forEach(result -> System.out.printf(MEMBER_RESULT_MESSAGE, result.memberName(), result.result()));
        }
        resultsDto.values()
                .stream()
                .filter(result -> resultMember.equals(result.memberName()))
                .forEach(result -> System.out.printf(MEMBER_RESULT_MESSAGE, result.memberName(), result.result()));
    }

    private static void printMembers(MembersDto members) {
        members.info()
                .forEach(member -> System.out.printf("%5s ", member.name()));
        System.out.println();
    }

    private static void printLadder(LadderDto ladder) {
        ladder.lines()
                .stream()
                .map(ResultView::printLines)
                .forEach(System.out::println);
    }

    private static void printResult(List<String> results) {
        results.forEach(result -> System.out.printf("%5s ", result));
        System.out.println(LINE_SEPARATOR);
    }

    private static String printLines(LineDto line) {
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
