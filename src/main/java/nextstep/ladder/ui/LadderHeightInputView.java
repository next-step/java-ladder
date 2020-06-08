package nextstep.ladder.ui;

import java.util.Scanner;

public class LadderHeightInputView {
    private static final int MIN_LADDER_HEIGHT = 1;
    private static final String INPUT_LADDER_HEIGHT_COMMENT = System.lineSeparator() + "최대 사다리 높이는 몇 개인가요?";

    private int maxLadderHeight;

    public LadderHeightInputView(int maxLadderHeight) {
        validateLadderHeight(maxLadderHeight);
        this.maxLadderHeight = maxLadderHeight;
    }

    public static LadderHeightInputView createByUserInput(Scanner scanner) {
        System.out.println(INPUT_LADDER_HEIGHT_COMMENT);
        return new LadderHeightInputView(scanner.nextInt());
    }

    public int getMaxLadderHeight() {
        return maxLadderHeight;
    }

    private void validateLadderHeight(int maxLadderHeight) {
        if (maxLadderHeight < MIN_LADDER_HEIGHT) {
            throw new IllegalArgumentException("Max Ladder Height must bigger than 0");
        }
    }
}
