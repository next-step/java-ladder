package nextstep.ladder.step4.view;

import nextstep.ladder.step4.utils.ScannerUtil;

public class InputView {

    private static final String INPUT_PLAYERS_NAME = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String INPUT_CATEGORY_NAME = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    private static final String INPUT_HEIGHT = "최대 사다리 높이는 몇 개인가요?";
    private static final String INPUT_RESULT_PLAYER_NAME = "결과를 보고 싶은 사람은?";

    private InputView() {
    }

    public static String players() {
        System.out.println(INPUT_PLAYERS_NAME);
        return ScannerUtil.nextLine();
    }

    public static String category() {
        System.out.println(INPUT_CATEGORY_NAME);
        return ScannerUtil.nextLine();
    }

    public static int height() {
        System.out.println(INPUT_HEIGHT);
        return ScannerUtil.nextInt();
    }

    public static String resultPlayerName() {
        System.out.println(INPUT_RESULT_PLAYER_NAME);
        return ScannerUtil.nextLine();
    }

}
