package ladder.core.message;

public abstract class Message {
    public boolean isGamerStep() {
        return false;
    }
    
    public boolean isLadderSizeStep() {
        return false;
    }
    
    public boolean isResultStep() {
        return false;
    }
    
    public boolean isInputGamerNameStep() {
        return false;
    }
    
    public boolean isRewardStep() {
        return false;
    };
    
    public boolean isInputRewardStep() {
        return false;
    };
}
