package nextstep.laddergame.domain;

public class LadderPiece {
    private LadderPiece leftLadderPiece = null;
    private LadderPiece rightLadderPiece = null;
    private BridgePositionEnum bridgePosition = BridgePositionEnum.NONE;

    public void setLeftLadderPiece(LadderPiece leftLadderPiece) {
        this.leftLadderPiece = leftLadderPiece;
    }

    public void setRightLadderPiece(LadderPiece rightLadderPiece) {
        this.rightLadderPiece = rightLadderPiece;
    }

    public void setBridgePosition(BridgePositionEnum bridgePosition) {
        this.bridgePosition = bridgePosition;
    }

    public BridgePositionEnum getBridgePosition() {
        return bridgePosition;
    }

    private boolean isAbleSetBridge() {
        return this.rightLadderPiece != null && this.bridgePosition.equals(BridgePositionEnum.NONE);
    }

    // 가로 사다리(Bridge) 는 left -> right 방향으로만 생성한다.
    public void settingBridge(BridgeInterface bridgeInterface) {
        if (isAbleSetBridge() && bridgeInterface.ifDrawBridge()) {
            this.bridgePosition = BridgePositionEnum.RIGHT;
            this.rightLadderPiece.setBridgePosition(BridgePositionEnum.LEFT);
        }
    }
}
