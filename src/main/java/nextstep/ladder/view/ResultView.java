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

    public static void printResult(InputOutput inputOutput, Ladder ladder) {
        printLadder(inputOutput, ladder);
    }

    private static void printLadder(InputOutput inputOutput, Ladder ladder) {
        System.out.println("\n사다리 결과\n");
        printNames(inputOutput, ladder);
        printLines(inputOutput, ladder);
        printExecuteResults(inputOutput);
    }

    private static void printNames(InputOutput inputOutput, Ladder ladder) {
        System.out.println(makeNames(inputOutput, ladder));
    }

    private static String makeNames(InputOutput inputOutput, Ladder ladder) {
        List<Person> people = inputOutput.people().value();

        return IntStream.range(BEGIN_INDEX, people.size())
                .mapToObj(i -> {
                    String name = people.get(i).name();

                    if (BEGIN_INDEX == i) {
                        return name;
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append(" ".repeat(NAME_SPACE - name.length()));
                    sb.append(name);
                    return sb.toString();
                })
                .collect(Collectors.joining());
    }

    private static void printLines(InputOutput inputOutput, Ladder ladder) {
        System.out.println(makeLines(inputOutput, ladder));
    }

    private static String makeLines(InputOutput inputOutput, Ladder ladder) {
        People people = inputOutput.people();
        Lines lines = ladder.lines();

        return lines.value().stream()
                .map(line -> {
                    StringBuilder sb = new StringBuilder();
                    IntStream.range(BEGIN_INDEX, line.points().size())
                            .mapToObj(idx -> generatePointString(people, line, idx)
                            )
                            .forEach(sb::append);
                    return sb.toString();
                })
                .collect(Collectors.joining("\n"));
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

                    StringBuilder sb = new StringBuilder();
                    if (BEGIN_INDEX == i) {
                        sb.append(executeName);
                        sb.append(" ".repeat(NAME_SPACE - peopleName.length()));
                        return sb.toString();
                    }
                    sb.append(" ".repeat(NAME_SPACE - executeName.length()));
                    sb.append(executeName);
                    return sb.toString();
                })
                .collect(Collectors.joining());
    }

    private static String generatePointString(People people, Line line, int idx) {
        if (BEGIN_INDEX == idx) {
            return " ".repeat(people.firstPersonNameLength()) + "|";
        }
        return line.points().get(idx) ? "-----|" : "     |";
    }
}

