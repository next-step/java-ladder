package nextstep.laddergame.domain;

import nextstep.laddergame.enumerate.BridgePositionEnum;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LadderPieceTest {
    private static final LadderPiece ladderPiece = new LadderPiece();
    private static final LadderPiece startLadderPiece = new LadderPiece();
    private static final int startIndex = 1;

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

    @Test
    @DisplayName("사다리의 진행방향이 왼쪽 아래일 때 제대로 이동하는지 테스트")
    public void moveToLadderTest1() {
        startLadderPiece.setBridgePosition(BridgePositionEnum.LEFT);
        assertThat(startLadderPiece.moveToLadder(startIndex)).isEqualTo(startIndex - 1);
    }

    @Test
    @DisplayName("사다리의 진행방향이 오른쪽 아래일 때 제대로 이동하는지 테스트")
    public void moveToLadderTest2() {
        startLadderPiece.setBridgePosition(BridgePositionEnum.RIGHT);
        assertThat(startLadderPiece.moveToLadder(startIndex)).isEqualTo(startIndex + 1);
    }

    @Test
    @DisplayName("사다리의 진행방향이 아래일 때 제대로 이동하는지 테스트")
    public void moveToLadderTest3() {
        startLadderPiece.setBridgePosition(BridgePositionEnum.NONE);
        assertThat(startLadderPiece.moveToLadder(startIndex)).isEqualTo(startIndex);
    }
}
