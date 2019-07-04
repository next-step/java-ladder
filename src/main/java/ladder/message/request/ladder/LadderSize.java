package ladder.message.request.ladder;

import ladder.core.message.Request;

public class LadderSize implements Request {
    private final int inputNumber;
    
    public LadderSize(int inputNumber) {
        this.inputNumber = inputNumber;
    }
    
    public int getInputNumber() {
        return inputNumber;
    }
}
