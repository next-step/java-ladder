package nextstep.laddergame.domain;

import nextstep.laddergame.enumerate.BridgePositionEnum;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LadderPieceTest {
    private static final LadderPiece ladderPiece = new LadderPiece();

    @Test
    public void ladderPiece_init_test() {
        assertThat(ladderPiece.getBottomPiece()).isNull();
        assertThat(ladderPiece.getLeftPiece()).isNull();
        assertThat(ladderPiece.getRightPiece()).isNull();
        assertThat(ladderPiece.getBridgePosition()).isEqualTo(BridgePositionEnum.NONE);
    }

    @Test
    public void ladderPiece_bridge_connect_test() {
        LadderPiece leftLadderPiece = new LadderPiece();
        LadderPiece rightLadderPiece = new LadderPiece();
        leftLadderPiece.setRightPiece(rightLadderPiece);
        rightLadderPiece.setLeftPiece(leftLadderPiece);

        leftLadderPiece.settingBridge(() -> true);

        assertThat(leftLadderPiece.getBridgePosition()).isEqualTo(BridgePositionEnum.RIGHT);
        assertThat(rightLadderPiece.getBridgePosition()).isEqualTo(BridgePositionEnum.LEFT);
    }

}
