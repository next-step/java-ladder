package ladderGame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class LayerTest {

    @Test
    @DisplayName("생성된 층의 개수 확인")
    public void create() {

        Layer layer = Layer.of(Arrays.asList(true, false, true, false));
        assertThat(layer.getRungs().size()).isEqualTo(4);

    }

}