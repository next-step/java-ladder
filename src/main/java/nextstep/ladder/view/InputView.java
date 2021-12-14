package nextstep.ladder.view;

import java.util.Scanner;

public class InputView {
    private static final String REQUEST_MEMBER_NAME_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String REQUEST_MAX_LADDER_LENGTH = "최대 사다리 높이는 몇 개인가요?";

    private static final Scanner scanner = new Scanner(System.in);

    public static String requestMemberNames() {
        System.out.println(REQUEST_MEMBER_NAME_MESSAGE);
        return scanner.next();
    }

    public static int requestLadderHegiht() {
        System.out.println();
        System.out.println(REQUEST_MAX_LADDER_LENGTH);
        return scanner.nextInt();
    }
}
