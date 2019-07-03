package ladder.message.ladder;

import ladder.core.message.Request;

public class LadderSizeDTO implements Request {
    private final int inputNumber;
    
    public LadderSizeDTO(int inputNumber) {
        this.inputNumber = inputNumber;
    }
    
    public int getInputNumber() {
        return inputNumber;
    }
}
