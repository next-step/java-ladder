package ladder.view;

import ladder.util.InputViewUtil;

import java.util.Optional;

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
        Optional.ofNullable(value)
                .filter(elem -> elem > ZERO)
                .orElseThrow(IllegalArgumentException::new);
    }

    public int height() {
        return this.value;
    }
}
