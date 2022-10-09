package nextstep.laddergame;

public class LadderPiece {
    private LadderPiece leftLadderPiece = null;
    private LadderPiece rightLadderPiece = null;
    private boolean leftBridge = false;
    private boolean rightBridge = false;

    public LadderPiece getLeftLadderPiece() {
        return leftLadderPiece;
    }

    public LadderPiece getRightLadderPiece() {
        return rightLadderPiece;
    }

    public boolean isLeftBridge() {
        return leftBridge;
    }

    public boolean isRightBridge() {
        return rightBridge;
    }

    public void setLeftBridge(boolean leftBridge) {
        this.leftBridge = leftBridge;
    }

    public void setLeftLadderPiece(LadderPiece leftLadderPiece) {
        this.leftLadderPiece = leftLadderPiece;
    }

    public void setRightBridge(boolean rightBridge) {
        this.rightBridge = rightBridge;
    }

    public void setRightLadderPiece(LadderPiece rightLadderPiece) {
        this.rightLadderPiece = rightLadderPiece;
    }
}
