package ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("사다리 라인(가로) 테스트")
public class LadderLineTests {

    @DisplayName("라인 생성 테스트")
    @Test
    public void generateLadderLineTests() {
        assertThatCode(() -> LadderLine.newInstance(7)).doesNotThrowAnyException();
    }

    @DisplayName("라인 생성 (가로 라인이 연속으로 나오지 않는지) 테스트")
    @Test
    public void generateLadderConsecutiveBridgeTests() {
        LadderLine ladderLine = LadderLine.newInstance(5);
        List<LadderBridge> bridges = ladderLine.getBridges();
        System.out.println(bridges);

        LadderBridge preLadderBridge = LadderBridge.UN_EXIST;
        for (int i = 0; i < bridges.size(); i++) {
            assertTrue(validateConsecutiveBridge(preLadderBridge, bridges.get(i)));
            preLadderBridge = bridges.get(i);
        }
    }

    private static boolean validateConsecutiveBridge(LadderBridge preBridge, LadderBridge nowBridge) {
        if (preBridge != nowBridge || nowBridge == LadderBridge.UN_EXIST) {
            return true;
        }
        return false;
    }
}
