package ladder.view;

import java.util.Scanner;

public class InputView {
    private static final String JOIN_GUIDE_TEXT = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요.)";
    private static final String RESULT_STRING_GUIDE_TEXT = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요.)";
    private static final String MAX_LADDER_GUIDE_TEXT = "최대 사다리 높이는 몇 개인가요?";
    private static final String WANT_RESULT_OF_PERSON_NAME_TEXT = "결과를 보고 싶은 사람은?";

    private static final Scanner SCANNER = new Scanner(System.in);

    private InputView() {/*prevent creating instance.*/}

    public static String getJoinMembersString() {
        System.out.println(JOIN_GUIDE_TEXT);
        return SCANNER.nextLine();
    }

    public static String getResultsString() {
        System.out.println();
        System.out.println(RESULT_STRING_GUIDE_TEXT);
        return SCANNER.nextLine();
    }

    public static int getMaxLadderHeight() {
        System.out.println();
        System.out.println(MAX_LADDER_GUIDE_TEXT);
        String sHeight = SCANNER.nextLine();
        return Integer.parseInt(sHeight);
    }

    public static String getResultOfPersonName() {
        System.out.println();
        System.out.println(WANT_RESULT_OF_PERSON_NAME_TEXT);
        return SCANNER.nextLine();
    }
}
