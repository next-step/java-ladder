package ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("사다리 라인(가로) 테스트")
public class LadderLineTests {

    @DisplayName("라인 생성 테스트")
    @Test
    public void generateLadderLineTests() {
        assertThatCode(() -> LadderLine.newInstance()).doesNotThrowAnyException();
    }

    @DisplayName("라인 생성 (가로 라인이 연속으로 나오지 않는지) 테스트")
    @Test
    public void generateLadderLineTests() {
        LadderLine ladderLine = LadderLine.newInstance();
        boolean testResult = ladderLine.getPoints()
                .stream()
                .reduce(true, (point1, point2) -> point1.equalsTo(point2));
        assertTrue(testResult);
    }

    private static boolean testConsecutiveLine(boolean point1, boolean point2) {
        if (point1 != point2 || point1) {
            return true;
        }
        return false;
    }
}
