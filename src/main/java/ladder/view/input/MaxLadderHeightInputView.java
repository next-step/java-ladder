package ladder.view.input;

import ladder.util.InputViewUtil;

public class MaxLadderHeightInputView {
    public static final int ZERO = 0;

    private final int value;

    public MaxLadderHeightInputView() {
        this(getUserInput());
    }

    public MaxLadderHeightInputView(int value) {
        validate(value);
        this.value = value;
    }

    private static int getUserInput() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return InputViewUtil.getUserInputParseInt();
    }

    private void validate(int value) {
        if (value <= ZERO) {
            throw new IllegalArgumentException();
        }
    }

    public int height() {
        return this.value;
    }
}
