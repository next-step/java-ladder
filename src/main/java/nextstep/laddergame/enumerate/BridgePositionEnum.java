package nextstep.laddergame.enumerate;

import nextstep.laddergame.domain.LadderPiece;

import java.util.function.Function;

public enum BridgePositionEnum {
    LEFT(ladderPiece -> ladderPiece.getLeftPiece().getBottomPiece()),
    RIGHT(ladderPiece -> ladderPiece.getRightPiece().getBottomPiece()),
    NONE(LadderPiece::getBottomPiece);

    private Function<LadderPiece, LadderPiece> expression;

    BridgePositionEnum(Function<LadderPiece, LadderPiece> expression) {
        this.expression = expression;
    }

    public LadderPiece getNextPiece(LadderPiece ladderPiece) {
        return this.expression.apply(ladderPiece);
    }

    public static int getNextPositionIndex(BridgePositionEnum bridgePositionEnum) {
        if (bridgePositionEnum.equals(LEFT)) {
            return -1;
        }
        if (bridgePositionEnum.equals(RIGHT)) {
            return 1;
        }
        if (bridgePositionEnum.equals(NONE)) {
            return 0;
        }

        throw new RuntimeException("Need handling to new Enum element");
    }

}
