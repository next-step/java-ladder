package nextstep.ladder;

import java.util.Scanner;

public class InputView {
    public static final Scanner scanner = new Scanner(System.in);
    public static final String PARTICIPANTS_REQUEST = "참여할 사람 이름을 입력하세요.";
    public static final String LADDER_HEIGHT_REQUEST = "최대 사다리 높이를 입력하세요.";

    public static String participants() {
        System.out.println(PARTICIPANTS_REQUEST);
        return scanner.nextLine();
    }

    public static Ladder ladder() {
        System.out.println(LADDER_HEIGHT_REQUEST);
        int height = Integer.parseInt(scanner.nextLine());

        return new Ladder(height);
    }
}
