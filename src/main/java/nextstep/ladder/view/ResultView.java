package nextstep.ladder.view;

import nextstep.ladder.domain.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ResultView {

    private static final int BEGIN_INDEX = 0;
    private static final int NAME_SPACE = 6;

    static void printPeopleInputCommand() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
    }

    static void printExecuteResultCommand() {
        System.out.println("\n실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
    }

    static void printHeightInputCommand() {
        System.out.println("\n최대 사다리 높이는 몇 개인가요?");
    }

    public static void printLadder(InputOutput inputOutput, Ladder ladder) {
        System.out.println("\n사다리 결과\n");
        printNames(inputOutput);
        printLines(inputOutput, ladder);
        printExecuteResults(inputOutput);
    }

    private static void printNames(InputOutput inputOutput) {
        System.out.println(makeNames(inputOutput));
    }

    private static String makeNames(InputOutput inputOutput) {
        List<Person> people = inputOutput.people().value();

        return IntStream.range(BEGIN_INDEX, people.size())
                .mapToObj(i -> {
                    String name = people.get(i).name();

                    if (BEGIN_INDEX == i) {
                        return name;
                    }
                    return generateSpace(name) + name;
                })
                .collect(Collectors.joining());
    }

    private static void printLines(InputOutput inputOutput, Ladder ladder) {
        System.out.println(makeLines(inputOutput, ladder));
    }

    private static String makeLines(InputOutput inputOutput, Ladder ladder) {
        int firstPersonNameLength = inputOutput.people().firstPersonNameLength();
        String[][] result = ladder.result();

        return IntStream.range(BEGIN_INDEX, result.length)
                .mapToObj(i -> IntStream.range(BEGIN_INDEX, result[BEGIN_INDEX].length)
                        .mapToObj(j -> {
                            if (BEGIN_INDEX == j) {
                                return generateSpace(firstPersonNameLength) + "|";
                            }
                            return generateLine(result[i][j]);
                        })
                        .collect(Collectors.joining()))
                .collect(Collectors.joining("\n"));
    }

    private static String generateSpace(int firstPersonNameLength) {
        return " ".repeat(firstPersonNameLength);
    }

    private static String generateLine(String result) {
        if (isVerticalLine(result)) {
            return "|";
        }
        if (isHorizontalLine(result)) {
            return "-----";
        }
        return "     ";
    }

    private static boolean isVerticalLine(String result) {
        return "v".equals(result);
    }

    private static boolean isHorizontalLine(String result) {
        return "h".equals(result);
    }

    private static void printExecuteResults(InputOutput inputOutput) {
        System.out.println(makeExecuteResults(inputOutput));
    }

    private static String makeExecuteResults(InputOutput inputOutput) {
        List<ExecuteResult> executeResults = inputOutput.executeResults().value();
        List<Person> people = inputOutput.people().value();

        return IntStream.range(BEGIN_INDEX, executeResults.size())
                .mapToObj(i -> {
                    String executeName = executeResults.get(i).name();
                    String peopleName = people.get(i).name();

                    if (BEGIN_INDEX == i) {
                        return generateSpace(executeName, peopleName) + executeName;
                    }
                    return generateSpace(executeName) + executeName;
                })
                .collect(Collectors.joining());
    }

    private static String generateSpace(String executeName, String peopleName) {
        if (peopleName.length() - executeName.length() > 0) {
            return " ".repeat(peopleName.length() - executeName.length());
        }
        return "";
    }

    private static String generateSpace(String executeName) {
        return " ".repeat(NAME_SPACE - executeName.length());
    }

    public static void printPersonInputCommand() {
        System.out.println("\n결과를 보고 싶은 사람은?");
    }

    public static void printResult(Result result, String person) {
        printResultCommand();

        if ("all".equals(person)) {
            result.value().entrySet().stream()
                    .forEachOrdered(entry -> System.out.println(entry.getKey() + " : " + entry.getValue()));
            return;
        }
        System.out.println(result.get(person));

    }

    private static void printResultCommand() {
        System.out.println("\n실행 결과");
    }
}

