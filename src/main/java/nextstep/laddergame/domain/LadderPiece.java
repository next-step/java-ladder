package nextstep.laddergame.domain;

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

    private boolean isAbleSetBridge() {
        return this.rightLadderPiece != null && !this.leftBridge && !this.rightBridge;
    }

    // 가로 사다리(Bridge) 는 left -> right 방향으로만 생성한다.
    public void setBridge(BridgeInterface bridgeInterface) {
        if (isAbleSetBridge() && bridgeInterface.ifDrawBridge()) {
            this.rightBridge = true;
            this.rightLadderPiece.leftBridge = true;
        }
    }
}
