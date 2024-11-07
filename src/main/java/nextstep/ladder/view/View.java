package nextstep.ladder.view;

import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.Person;
import nextstep.ladder.domain.Winner;
import nextstep.ladder.vo.Result;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class View {
    public static final String SEPARATOR = System.lineSeparator();
    public static final String INPUT_PERSON_NAMES = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    public static final String INPUT_EXECUTE_RESULT = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    public static final String INPUT_COUNT_LADDER_HEIGHT = "최대 사다리 높이는 몇 개인가요?";
    public static final String INPUT_WHO_RESULT = SEPARATOR + "결과를 보고 싶은 사람은?";
    public static final String LADDER_RESULT = "사다리 결과";
    public static final String EXECUTE_RESULT = SEPARATOR + "실행 결과";
    public static final String LINE_START = "     |";
    public static final String LINE_TRUE = "-----";
    public static final String LINE_FALSE = "     ";
    public static final String LINE_END = "|";
    public static final String ALL = "all";
    private final Scanner SCANNER = new Scanner(System.in);

    public String inputNames() {
        System.out.println(INPUT_PERSON_NAMES);
        return SCANNER.nextLine();
    }

    public String inputExecuteResult() {
        System.out.println(SEPARATOR + INPUT_EXECUTE_RESULT);
        return SCANNER.nextLine();
    }

    public int inputCountLadderHeight() {
        System.out.println(SEPARATOR + INPUT_COUNT_LADDER_HEIGHT);
        return SCANNER.nextInt();
    }

    public void output(final Result result) {
        List<Person> persons = result.getPersons();
        List<Line> lines = result.getLines();
        List<Winner> winners = result.getWinners();

        printLadderResult(persons, lines, winners);

        printExecuteResult(winners);
    }

    private void printExecuteResult(List<Winner> winners) {
        while (true) {
            System.out.println(INPUT_WHO_RESULT);
            String name = SCANNER.nextLine();

            StringBuilder sb = new StringBuilder();
            sb.append(EXECUTE_RESULT);
            for (Winner winner : winners) {
                appendResult(winner, name, sb);
            }
            System.out.println(sb);
        }
    }

    private static void appendResult(Winner winner, String name, StringBuilder sb) {
        if (Objects.equals(winner.getPerson(), new Person(name))) {
            sb.append(winner.getResult());
        }
        if (Objects.equals(name, ALL)) {
            sb.append(winner.getName()).append(" : ").append(winner.getResult());
        }
    }

    private static void printLadderResult(List<Person> persons, List<Line> lines, List<Winner> winners) {
        StringBuilder sb = new StringBuilder();
        sb.append(SEPARATOR).append(LADDER_RESULT).append(SEPARATOR).append(SEPARATOR);
        for (Person person : persons) {
            sb.append(person.leftPad()).append(" ");
        }
        sb.append(SEPARATOR);
        for (Line line : lines) {
            appendLine(line, sb);
        }
        for (Winner winner : winners) {
            sb.append("\t").append(winner.getResult());
        }
        System.out.println(sb);
    }

    private static void appendLine(Line line, StringBuilder sb) {
        sb.append(LINE_START);
        for (int i = 0; i < line.size(); i++) {
            String value = line.isPointTrue(i) ? LINE_TRUE : LINE_FALSE;
            sb.append(value).append(LINE_END);
        }
        sb.append(SEPARATOR);
    }
}
