package nextstep.ladder.view;

import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.Person;
import nextstep.ladder.vo.Input;
import nextstep.ladder.vo.Result;

import java.util.List;
import java.util.Scanner;

public class View {
    public static final String SEPARATOR = System.lineSeparator();
    public static final String INPUT_PERSON_NAMES = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    public static final String INPUT_COUNT_LADDER_HEIGHT = "최대 사다리 높이는 몇 개인가요?";
    public static final String OUTPUT_RESULT = "실행 결과";
    private final Scanner scanner = new Scanner(System.in);

    public Input input() {
        System.out.println(INPUT_PERSON_NAMES);
        String names = scanner.nextLine();
        System.out.println(SEPARATOR + INPUT_COUNT_LADDER_HEIGHT);
        int countLadderHeight = scanner.nextInt();
        return new Input(names, countLadderHeight);
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
            sb.append(line.print()).append(SEPARATOR);
        }
        System.out.println(sb);
    }
}
