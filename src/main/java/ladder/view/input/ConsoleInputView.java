package ladder.view.input;

import java.util.Scanner;

public class ConsoleInputView implements InputView {

    public static final String PERSON_NAME_SEPARATOR = ",";
    public static final String INPUT_RESULT_SEPARATOR = ",";
    private final Scanner scanner = new Scanner(System.in);

    public String[] personNameInput() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(" + PERSON_NAME_SEPARATOR + ")로 구분하세요)");
        try {
            return splitPersonName(scanner.nextLine());
        } catch (Exception e) {
            return personNameInput();
        }
    }

    public String[] inputResultPeopleNames() {
        System.out.println("결과를 보고 싶은 사람은?");
        try {
            return inputPeopleNames(scanner.nextLine().trim());
        } catch (Exception e) {
            return inputResultPeopleNames();
        }
    }

    private String[] inputPeopleNames(String text) {
        if (text.contains(PERSON_NAME_SEPARATOR)) {
            return splitPersonName(text);
        }
        return new String[]{text};
    }

    private String[] splitPersonName(String text) {
        return text.split(PERSON_NAME_SEPARATOR);
    }

    public String[] splitResult() {
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(" + INPUT_RESULT_SEPARATOR + ")로 구분하세요)");
        try {
            return scanner.nextLine().split(INPUT_RESULT_SEPARATOR);
        } catch (Exception e) {
            return splitResult();
        }
    }

    public int ladderHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (Exception e) {
            return ladderHeight();
        }
    }
}
