package ladder.view;

import ladder.domain.Game;
import ladder.domain.Person;
import ladder.domain.PersonList;
import ladder.domain.Result;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class InputView {

    private static final String DELIMITER = ",";

    private InputView() {
    }

    public static String[] inputPersonData() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        Scanner scanner = new Scanner(System.in);
        return splitInputs(scanner);
    }

    public static String[] inputResultData() {
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        Scanner scanner = new Scanner(System.in);
        return splitInputs(scanner);
    }

    public static int inputLadderHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public static String inputFindResultKeyword() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("결과를 보고 싶은 사람은?");
        return scanner.nextLine();
    }

    private static String[] splitInputs(Scanner scanner) {
        String inputNames = scanner.nextLine();
        return inputNames.replaceAll("\\s", "").split(DELIMITER);
    }
}
