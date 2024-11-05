package nextstep.ladder.view;

import nextstep.ladder.domain.Persons;
import nextstep.ladder.domain.Results;

import java.util.Scanner;

public class InputView {
    private final static String SPLIT_DELIMITER = ",";
    private final static String REQUEST_NAMES = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private final static String REQUEST_RESULT = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    private final static String REQUEST_HEIGHT_COUNT = "최대 사다리 높이는 몇 개인가요?";
    private final static String REQUEST_WHO = "결과를 보고 싶은 사람은?";
    private static Scanner scanner = new Scanner(System.in);

    public static Persons requestNames() {
        System.out.println(REQUEST_NAMES);
        return new Persons(split(scanner.nextLine()));
    }

    public static Results requestResults() {
        System.out.println(REQUEST_RESULT);
        return new Results(split(scanner.nextLine()));
    }

    public static int requestHeightCount() {
        System.out.println(REQUEST_HEIGHT_COUNT);
        return toInt(scanner.nextLine());
    }

    public static String viewPerson() {
        System.out.println(REQUEST_WHO);
        return scanner.nextLine();
    }

    private static String[] split(String text) {
        return text.split(SPLIT_DELIMITER);
    }

    private static int toInt(String text) {
        return Integer.parseInt(text);
    }

}
