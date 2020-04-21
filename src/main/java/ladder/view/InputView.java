package ladder.view;

import ladder.dto.LadderRequest;

import java.util.Scanner;

public class InputView {
    private static final String USERS_REQUEST = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String REWARD_REQUEST = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    private static final String HEIGHT_REQUEST = "최대 사다리 높이는 몇 개인가요?";
    private static final String RESULT_REQUEST = "결과를 보고 싶은 사람은?";
    private static final Scanner scanner = new Scanner(System.in);

    public static LadderRequest inputLadderInfo() {
        return new LadderRequest(inputNames(), inputRewards(), inputHeight());
    }

    private static String inputNames() {
        System.out.println(USERS_REQUEST);
        return scanner.nextLine();
    }

    private static String inputRewards() {
        System.out.println(REWARD_REQUEST);
        return scanner.nextLine();
    }

    private static int inputHeight() {
        System.out.println(HEIGHT_REQUEST);
        return Integer.parseInt(scanner.nextLine());
    }

    public static String inputTarget() {
        System.out.println(RESULT_REQUEST);
        return scanner.nextLine();
    }
}
