package ladder.domain;

import ladder.util.ErrorMessage;

public class InputValueStatus {

    private static int MIN_LADDER_HEIGHT = 0;

    private String names;
    private int ladderHeight;

    public InputValueStatus(String names, int ladderHeight) {
        checkValue(names, ladderHeight);
        this.names = names;
        this.ladderHeight = ladderHeight;
    }

    public void checkValue(String names, int ladderHeight) {
        checkName(names);
        checkLadderHeight(ladderHeight);
    }

    private void checkLadderHeight(int ladderHeight) {
        if (ladderHeight <= MIN_LADDER_HEIGHT) {
            throw new RuntimeException(ErrorMessage.getCheckInputLadderHeight());
        }
    }

    private void checkName(String names) {
        isNullOrEmpty(names);
    }

    private void isNullOrEmpty(String names) {
        if (names.isEmpty()) {
            throw new NullPointerException(ErrorMessage.getCheckInputNames());
        }
    }
}
