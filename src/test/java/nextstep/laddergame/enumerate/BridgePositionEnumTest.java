package nextstep.laddergame.enumerate;

import nextstep.laddergame.domain.LadderPiece;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BridgePositionEnumTest {
    private static final LadderPiece startLadderPiece = new LadderPiece();

    @BeforeAll
    public static void makeCustomMiniLadder() {
        LadderPiece leftLadderPiece = new LadderPiece();
        LadderPiece secondLeftLadderPiece = new LadderPiece();
        LadderPiece rightLadderPiece = new LadderPiece();
        LadderPiece secondRightLadderPiece = new LadderPiece();
        LadderPiece bottomLadderPiece = new LadderPiece();

        startLadderPiece.setLeftPiece(leftLadderPiece);
        leftLadderPiece.setBottomPiece(secondLeftLadderPiece);
        startLadderPiece.setRightPiece(rightLadderPiece);
        rightLadderPiece.setBottomPiece(secondRightLadderPiece);
        startLadderPiece.setBottomPiece(bottomLadderPiece);
    }

    @Test
    public void getNextPiece_LEFT_test() {
        LadderPiece actual = BridgePositionEnum.LEFT.getNextPiece(startLadderPiece);
        LadderPiece expect = startLadderPiece.getLeftPiece().getBottomPiece();
        assertThat(actual).isEqualTo(expect);
    }

    @Test
    public void getNextPiece_RIGHT_test() {
        LadderPiece actual = BridgePositionEnum.RIGHT.getNextPiece(startLadderPiece);
        LadderPiece expect = startLadderPiece.getRightPiece().getBottomPiece();
        assertThat(actual).isEqualTo(expect);
    }

    @Test
    public void getNextPiece_NONE_test() {
        LadderPiece actual = BridgePositionEnum.NONE.getNextPiece(startLadderPiece);
        LadderPiece expect = startLadderPiece.getBottomPiece();
        assertThat(actual).isEqualTo(expect);
    }

    @Test
    void getNextPositionIndexTest() {
        assertThat(BridgePositionEnum.getNextPositionIndex(BridgePositionEnum.LEFT)).isEqualTo(-1);
        assertThat(BridgePositionEnum.getNextPositionIndex(BridgePositionEnum.NONE)).isEqualTo(0);
        assertThat(BridgePositionEnum.getNextPositionIndex(BridgePositionEnum.RIGHT)).isEqualTo(1);
    }
}