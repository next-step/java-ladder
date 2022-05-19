package nextstep.ladder.view;

import nextstep.ladder.model.Line;
import nextstep.ladder.model.Person;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final int ZERO = 0;
    private static final String COMMA = ",";
    private static final String INPUT_NAMES_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String INPUT_MAX_HEIGHT_MESSAGE = "최대 사다리 높이는 몇 개인가요?";

    private InputView() {
    }

    public static String inputString() {
        return SCANNER.nextLine();
    }

    public static int inputInteger() {
        return Integer.parseInt(inputString());
    }

    public static List<Person> createPeople() {
        ResultView.println(INPUT_NAMES_MESSAGE);
        String plainNames = inputString();
        ResultView.println();
        return Stream
                .of(plainNames.split(COMMA))
                .map(Person::is)
                .collect(Collectors.toList());
    }

    public static List<Line> inputMaxHeight(int countOfPeople) {
        ResultView.println(INPUT_MAX_HEIGHT_MESSAGE);
        int maxHeight = inputInteger();
        ResultView.println();
        return IntStream
                .range(ZERO, maxHeight)
                .mapToObj(i -> Line.create(countOfPeople))
                .collect(Collectors.toList());
    }
}
