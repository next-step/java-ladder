import java.util.Scanner;

public class InputView {
    private static final String JOIN_GUIDE_TEXT = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요.";
    private static final String MAX_LADDER_GUIDE_TEXT = "최대 사다리 높이는 몇 개인가요?";

    private static final Scanner SCANNER = new Scanner(System.in);

    private InputView() {/*prevent creating instance.*/}

    public static String getJoinMembersString() {
        System.out.println(JOIN_GUIDE_TEXT);
        return SCANNER.nextLine();
    }

    public static int getMaxLadderHeight() {
        System.out.println(MAX_LADDER_GUIDE_TEXT);
        return SCANNER.nextInt();
    }
}
