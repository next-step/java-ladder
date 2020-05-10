package ladder.view;


import java.util.Scanner;

public class InputView {

    private static String INFORMATION_USER_NAMES = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static String INFORMATION_REWARD = "실행 결과를 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static String INFORMATION_LADDER_HEIGHT = "최대 사다리 높이는 몇 인가요?";
    private static String INFORMATION_RESULT_PER_USER = "결과를 보고 싶은 사람은?";

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

    public String rewardReader() {
        return userInstructionToString(INFORMATION_REWARD);
    }

    public int ladderHeightReader() {
        return userInstructionToNumber(INFORMATION_LADDER_HEIGHT);
    }

    public String userNameReader() {
        return userInstructionToString(INFORMATION_RESULT_PER_USER);
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
