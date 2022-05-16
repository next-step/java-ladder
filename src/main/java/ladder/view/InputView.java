package ladder.view;

import ladder.utils.InputUtils;

public class InputView {
    public static String inputParticipants() {
        return InputUtils.scan("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
    }

    public static int inputMaxLadderHeight() {
        return InputUtils.scanNumber("최대 사다리 높이는 몇 개인가요?");
    }
}
