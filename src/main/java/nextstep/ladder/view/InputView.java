package nextstep.ladder.view;

import java.util.Scanner;

public class InputView {
    private static final String REQUEST_MEMBER_NAME_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String REQUEST_REWARDS_MESSAGE = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요";
    private static final String REQUEST_MAX_LADDER_LAYER = "최대 사다리 높이는 몇 개인가요?";
    private static final String REQUEST_REWARDS_MEMBER_MESSAGE = "결과를 보고 싶은 사람은?";
    private static final Scanner scanner = new Scanner(System.in);

    public static String requestMemberNames() {
        System.out.println(REQUEST_MEMBER_NAME_MESSAGE);
        return scanner.next();
    }

    public static String requestRewards() {
        System.out.println();
        System.out.println(REQUEST_REWARDS_MESSAGE);
        return scanner.next();
    }

    public static int requestLadderLayer() {
        System.out.println();
        System.out.println(REQUEST_MAX_LADDER_LAYER);
        return scanner.nextInt();
    }

    public static String requestResultMember() {
        System.out.println();
        System.out.println();
        System.out.println(REQUEST_REWARDS_MEMBER_MESSAGE);
        return scanner.next();
    }
}
