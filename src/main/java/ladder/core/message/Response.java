package ladder.core.message;

public abstract class Response {
    public boolean isGamerStep() {
        return false;
    }
    
    public boolean isLadderSizeStep() {
        return false;
    }
    
    public boolean isRewardInputStep() {
        return false;
    }
    
    public boolean isResultStep() {
        return false;
    }
    
    public boolean isGamerNameInputStep() {
        return false;
    }
    
    public boolean isRewardStep() {
        return false;
    }
}
