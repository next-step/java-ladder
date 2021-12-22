package nextstep.ladder.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LadderLayerTest {
    @Test
    void 생성자_비교() {
        assertThat(new LadderLayer(5).getLayer()).isEqualTo(5);
    }

    @ParameterizedTest(name="{displayName} | 요청값: {0}")
    @ValueSource(ints = {-1, 0})
    void 비정상적인_Layer_IllegalArgumentException(int param) {
        assertThatThrownBy(() -> {
            new LadderLayer(param);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
