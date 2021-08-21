package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LineTest {

    @Test
    @DisplayName("라인 생성시 사람수가 2보다 작으면 IllegalArgumentException이 발생한다.")
    void personCountException() {
        int personCount = 1;
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Line(personCount, () -> true))
                .withMessage("사다리 게임에 참여하는 사람 수가 너무 작습니다. 사람 수 : " + personCount);
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8})
    @DisplayName("항상 true인 확률로 라인생성 했을 때 라인은 사람 수 / 2 만큼 생성된다. 0, 2, 4 순으로 True 이다.")
    void trueConstructor(int personCount) {
        int lineCountExpect = personCount / 2;
        Line line = new Line(personCount, () -> true);
        long lineCountActual = line.getPoints().stream()
                .filter(point -> point)
                .count();
        assertEquals(lineCountExpect, lineCountActual);
        IntStream.range(0, personCount / 2).forEach(idx ->
                assertTrue(line.getPoints().get(idx * 2)));
    }

}