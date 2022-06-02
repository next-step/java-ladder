package ladder.view;

import java.util.Scanner;

public class InputView {
    private final static Scanner sc = new Scanner(System.in);
    private static final String ENTER = System.lineSeparator();

    private InputView(){}

    public static String inputParticipantsNames() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        return sc.nextLine();
    }

    public static int inputHeightOfLadder() {
        System.out.println(ENTER + "최대 사다리 높이는 몇 개인가요?");
        return Integer.parseInt(sc.nextLine());
    }

    public static String inputExecutionResult() {
        System.out.println(ENTER + "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        return sc.nextLine();
    }

    public static String inputParticipantNameToSeeExecutionResult() {
        System.out.println(ENTER + "결과를 보고 싶은 사람은?");
        return sc.nextLine();
    }
}
