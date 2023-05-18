package nextstep.ladder.domain;

import nextstep.ladder.domain.strategy.BridgeStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class LineTest {

    @DisplayName("중복된 다리가 있을 경우 중복된 다리를 삭제한다.")
    @Test
    void when_hasDuplicateBridge_Expect_EraseBridge() {
        int width = 10;
        BridgeStrategy strategy = () -> true;

        assertThatNoException()
                .isThrownBy(() -> new Line(width, strategy));
    }

    @DisplayName("getter 호출 시 라인의 다리 리스트 여부를 가져 온다.")
    @Test
    void when_callingGetter_Expects_returnBridgeLists() {
        int width = 6;
        BridgeStrategy strategy = () -> true;
        List<Boolean> expected = List.of(true, false, true, false, true);

        Line line = new Line(width, strategy);

        assertThat(line.getPoints()).isEqualTo(expected);
    }

    @DisplayName("Boolean 리스트에서 입력받은 인덱스의 값을 반환한다")
    @ParameterizedTest
    @ValueSource(ints = {0, 2, 4})
    public void dummy(int index) {
        List<Boolean> points = List.of(true, false, true, false, true);
        Line line = new Line(points);

        assertThat(line.get(index)).isTrue();
    }
}