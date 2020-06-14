package ladder.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("사다리 라인(가로) 테스트")
public class LadderLineTest {

    @DisplayName("라인 생성 테스트")
    @Test
    public void createLadderLineTests() {
        assertThatCode(() -> LadderLine.create(7)).doesNotThrowAnyException();
    }

    @DisplayName("라인 생성 - 비정상 테스트")
    @Test
    public void createLadderLineAbnormalTests() {
        assertThatIllegalArgumentException()
            .isThrownBy(() -> LadderLine.create(-1))
            .withMessageContaining("참여하는 멤버는 1명 이상이어야 합니다.");

        assertThatIllegalArgumentException()
            .isThrownBy(() -> LadderLine.create(0))
            .withMessageContaining("참여하는 멤버는 1명 이상이어야 합니다.");
    }

    @DisplayName("라인 생성 - 사이즈 테스트")
    @Test
    public void compareLadderLineTests() {
        LadderLine ladderLine = LadderLine.create(7);
        List<LadderBridge> bridges = ladderLine.getBridges();
        assertThat(bridges.size()).isEqualTo(6);
    }

    @DisplayName("라인 생성 (가로 라인이 연속으로 나오지 않는지) 테스트")
    @Test
    public void createLadderConsecutiveBridgeTests() {
        LadderLine ladderLine = LadderLine.create(5);
        List<LadderBridge> bridges = ladderLine.getBridges();

        LadderBridge preLadderBridge = LadderBridge.NOT_EXIST;
        for (int i = 0; i < bridges.size(); i++) {
            assertTrue(validateConsecutiveBridge(preLadderBridge, bridges.get(i)));
            preLadderBridge = bridges.get(i);
        }
    }

    private static boolean validateConsecutiveBridge(LadderBridge preBridge, LadderBridge nowBridge) {
        return preBridge != nowBridge || nowBridge == LadderBridge.NOT_EXIST;
    }
}