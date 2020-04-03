package ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("사다리 라인(가로) 테스트")
public class LadderLineTests {
    /*
     * 사다리 높이를 입력 받는다. (숫자)
     * 사다리는 입력받은 높이만큼, 참여자 숫자만큼 생성된다.
     * 예를 들어 참여자가 4명, 높이가 5인경우, 4 * 5 사다리가 생성된다.
     * 각 사다리 세로 사이엔 이동할 수 있는 가로 라인이 들어갈 수 있다.
     * 사다리 타기가 정상적으로 동작하려면 가로 라인이 겹치지 않아야 한다. (연속해서 라인이 나올 수 없다.)
     * 참여자와 완성된 사다리를 출력한다.
     */

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
