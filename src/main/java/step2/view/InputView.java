package step2.view;

import java.util.Scanner;

public class InputView {
    private final static Scanner scanner = new Scanner(System.in);
    public static final String PARTICIPATION = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    public static final String REWARDS = "실행 결과를 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    public static final String LADDER_HEIGHT = "최대 사다리 높이는 몇 개 인가요?";

    private InputView() {}

    public static String putParticipation() {
        System.out.println(PARTICIPATION);
        return scanner.next();
    }
    public static String putReward() {
        System.out.println(REWARDS);
        return scanner.next();
    }

    public static int putLadderHeight() {
        System.out.println(LADDER_HEIGHT);
        return scanner.nextInt();
    }
}
