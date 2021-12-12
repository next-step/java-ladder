package nextstep.ladder.view;

import nextstep.ladder.util.ScannerUtils;

public class InputView {

    private InputView() {
    }

    public static String inputPlayerName() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        return ScannerUtils.nextLine();
    }

    public static String inputExecutionResult() {
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        return ScannerUtils.nextLine();
    }

    public static String inputLadderLength() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return ScannerUtils.nextLine();
    }

}
