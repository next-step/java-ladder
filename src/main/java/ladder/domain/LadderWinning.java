package ladder.domain;

import ladder.util.ErrorMessage;

public class LadderWinning {
    private String winning;

    public LadderWinning(String winning){
        checkEmpty(winning);
        this.winning = winning;
    }

    private void checkEmpty(final String winning) {
        if (winning == null) {
            throw new RuntimeException(ErrorMessage.getCheckInputWinning());
        }
    }

    public String getWinning() {
        return winning;
    }
}
