package nextstep.laddergame.domain;

import java.util.EnumMap;

public class LadderPiece {
    private EnumMap<DirectionEnum, LadderPiece> nextLadderPieceMap = new EnumMap(DirectionEnum.class);
    private BridgePositionEnum bridgePosition = BridgePositionEnum.NONE;

    public LadderPiece() {
        nextLadderPieceMap.put(DirectionEnum.BOTTOM, null);
        nextLadderPieceMap.put(DirectionEnum.LEFT, null);
        nextLadderPieceMap.put(DirectionEnum.RIGHT, null);
    }

    public LadderPiece getRightPiece() {
        return this.nextLadderPieceMap.get(DirectionEnum.RIGHT);
    }

    public LadderPiece getLeftPiece() {
        return this.nextLadderPieceMap.get(DirectionEnum.LEFT);
    }

    public LadderPiece getBottomPiece() {
        return this.nextLadderPieceMap.get(DirectionEnum.BOTTOM);
    }

    public LadderPiece setBottomPiece(LadderPiece ladderPiece) {
        return this.nextLadderPieceMap.put(DirectionEnum.BOTTOM, ladderPiece);
    }

    public LadderPiece setRightPiece(LadderPiece ladderPiece) {
        return this.nextLadderPieceMap.put(DirectionEnum.RIGHT, ladderPiece);
    }

    public LadderPiece setLeftPiece(LadderPiece ladderPiece) {
        return this.nextLadderPieceMap.put(DirectionEnum.LEFT, ladderPiece);
    }

    public void setBridgePosition(BridgePositionEnum bridgePosition) {
        this.bridgePosition = bridgePosition;
    }

    public BridgePositionEnum getBridgePosition() {
        return bridgePosition;
    }

    private boolean isAbleSetBridge() {
        return this.nextLadderPieceMap.get(DirectionEnum.RIGHT) != null && this.bridgePosition.equals(BridgePositionEnum.NONE);
    }

    // 가로 사다리(Bridge) 는 left -> right 방향으로만 생성한다.
    public void settingBridge(BridgeInterface bridgeInterface) {
        if (isAbleSetBridge() && bridgeInterface.ifDrawBridge()) {
            this.bridgePosition = BridgePositionEnum.RIGHT;
            this.getRightPiece().setBridgePosition(BridgePositionEnum.LEFT);
        }
    }
}
