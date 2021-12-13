package nextstep.ladder.view;

import nextstep.ladder.util.ScannerUtils;

public class InputView {

    private static final String PLAYERS_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String CATEGORY_MESSAGE = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    private static final String HEIGHT_MESSAGE = "최대 사다리 높이는 몇 개인가요?";
    private static final String PLAYER_RESULT_MESSAGE = "결과를 보고 싶은 사람은?";

    private InputView() {
    }

    public static String inputPlayers() {
        System.out.println(PLAYERS_MESSAGE);
        return ScannerUtils.nextLine();
    }

    public static String inputCategory() {
        System.out.println(CATEGORY_MESSAGE);
        return ScannerUtils.nextLine();
    }

    public static int inputHeight() {
        System.out.println(HEIGHT_MESSAGE);
        return ScannerUtils.nextInt();
    }

    public static String inputPlayerResult() {
        System.out.println(PLAYER_RESULT_MESSAGE);
        return ScannerUtils.nextLine();
    }
}
