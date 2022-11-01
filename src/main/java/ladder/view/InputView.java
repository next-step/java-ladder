package ladder.view;

import java.util.Scanner;

import static ladder.util.LadderConst.*;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    public static String[] personNameInput() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(" + PERSON_NAME_SEPARATOR + ")로 구분하세요)");
        return splitPersonName(scanner.nextLine());
    }

    public static String[] splitPersonName(String text) {
        return text.split(PERSON_NAME_SEPARATOR);
    }

    public static String[] splitResult() {
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(" + INPUT_RESULT_SEPARATOR + ")로 구분하세요)");
        return scanner.nextLine().split(INPUT_RESULT_SEPARATOR);
    }

    public static int ladderHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return Integer.parseInt(scanner.nextLine());
    }

    public static String[] inputResultPersonName() {
        System.out.println("결과를 보고 싶은 사람은?");
        String text = scanner.nextLine().trim();
        if (text.contains(PERSON_NAME_SEPARATOR)) {
            return splitPersonName(text);
        }
        return new String[]{text};
    }
}
