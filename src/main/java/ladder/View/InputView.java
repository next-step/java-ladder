package ladder.View;


import java.util.Scanner;

public class InputView {

    private static String INFORMATION_USER_NAMES = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static String INFORMATION_LADDER_HEIGHT = "최대 사다리 높이는 몇 인가요?";

    private Scanner scanner;

    private InputView() {
        this.scanner = new Scanner(System.in);
    }

    public static InputView of() {
        return new InputView();
    }

    public String userNamesReader() {
        return userInstructionToString(INFORMATION_USER_NAMES);
    }

    public int ladderHeightReader() {
        return userInstructionToNumber(INFORMATION_LADDER_HEIGHT);
    }

    private int userInstructionToNumber(String message) {
        System.out.println(message);
        return Integer.parseInt(scanner.nextLine());
    }

    private String userInstructionToString(String massage) {
        System.out.println(massage);
        return scanner.nextLine();
    }
}
