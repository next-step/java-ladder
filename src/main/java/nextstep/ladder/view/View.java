package nextstep.ladder.view;

import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.Person;
import nextstep.ladder.vo.Result;

import java.util.List;
import java.util.Scanner;

public class View {
    public static final String SEPARATOR = System.lineSeparator();
    public static final String INPUT_PERSON_NAMES = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    public static final String INPUT_COUNT_LADDER_HEIGHT = "최대 사다리 높이는 몇 개인가요?";
    public static final String OUTPUT_RESULT = "실행 결과";
    public static final String LINE_START = "     |";
    public static final String LINE_TRUE = "-----";
    public static final String LINE_FALSE = "     ";
    public static final String LINE_END = "|";
    private final Scanner scanner = new Scanner(System.in);

    public String inputNames() {
        System.out.println(INPUT_PERSON_NAMES);
        return scanner.nextLine();
    }

    public int inputCountLadderHeight() {
        System.out.println(SEPARATOR + INPUT_COUNT_LADDER_HEIGHT);
        return scanner.nextInt();
    }

    public void output(final Result result) {
        List<Person> persons = result.getPersons();
        List<Line> lines = result.getLines();

        StringBuilder sb = new StringBuilder();
        sb.append(SEPARATOR).append(OUTPUT_RESULT).append(SEPARATOR);
        for (Person person : persons) {
            sb.append(person.leftPad()).append(" ");
        }
        sb.append(SEPARATOR);
        for (Line line : lines) {
            appendLine(line, sb);
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
