package ladder.view;

import ladder.domain.Game;
import ladder.domain.Person;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    public static final String DELIMITER = ",";

    private InputView() {
    }

    public static Game inputGameData() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String[] names = splitNames(scanner);
        List<Person> personList = Arrays.stream(names).map(Person::new).collect(Collectors.toList());

        System.out.println("최대 사다리 높이는 몇 개인가요?");
        int ladderHeight = scanner.nextInt();

        return new Game(personList, ladderHeight);
    }

    private static String[] splitNames(Scanner scanner) {
        String inputNames = scanner.nextLine();
        return inputNames.replaceAll("\\s", "").split(DELIMITER);
    }
}
