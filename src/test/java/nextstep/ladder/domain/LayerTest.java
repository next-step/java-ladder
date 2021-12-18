package nextstep.ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LayerTest {
    @Test
    void 생성자_비교() {
        Layer layer = new Layer(5, 1);
        assertThat(layer).isEqualTo(new Layer(5));
    }

    @Test
    void 최소보다_낮은_생성자() {
        assertThatThrownBy(() -> {
            new Layer(0);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 다음층_비교() {
        Layer layer = new Layer(5, 2);
        layer.nextLayer();
        assertThat(layer.moreLayer()).isTrue();
    }

    @Test
    void 마지막층_비교() {
        Layer layer = new Layer(5, 5);
        layer.nextLayer();
        assertThat(layer.moreLayer()).isFalse();
    }
}
