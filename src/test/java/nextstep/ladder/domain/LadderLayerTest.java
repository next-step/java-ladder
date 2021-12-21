package nextstep.ladder.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LadderLayerTest {
    @Test
    void 생성자_비교() {
        LadderLayer ladderLayer = new LadderLayer(5, 1);
        assertThat(ladderLayer).isEqualTo(new LadderLayer(5));
    }

    @ParameterizedTest(name="{displayName} | 요청값: {0}")
    @ValueSource(ints = {-1, 0})
    void 최소보다_낮은_생성자(int param) {
        assertThatThrownBy(() -> {
            new LadderLayer(param);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest(name="{displayName} | 요청값: {0}")
    @ValueSource(ints = {-1, 6})
    void 비정상적인_nowLayer_IllegalArgumentException(int param) {
        assertThatThrownBy(() -> {
            new LadderLayer(5, param);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest(name="{displayName} | 요청값: {0}")
    @ValueSource(ints = {1, 2, 3, 4})
    void 다음층_비교(int param) {
        LadderLayer ladderLayer = new LadderLayer(5, param);
        ladderLayer.nextLayer();
        assertThat(ladderLayer.moreLayer()).isTrue();
    }

    @Test
    void 마지막층_비교() {
        LadderLayer ladderLayer = new LadderLayer(5, 5);
        ladderLayer.nextLayer();
        assertThat(ladderLayer.moreLayer()).isFalse();
    }
}
