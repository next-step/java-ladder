package ladderGame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LayerTest {

    @Test
    @DisplayName("생성된 층의 개수 확인")
    public void create() {
        Layer layer = Layer.of(Arrays.asList(true, false, true, false));
        assertThat(layer.getRungs().size()).isEqualTo(4);
    }

    @Test
    @DisplayName("참가자 수로 생성된 층의 개수 확인")
    public void createByEntry() {
        Layer layer = Layer.fromNumberOfPlayer(5);
        assertThat(layer.getRungs().size()).isEqualTo(4);
    }

    @Test
    @DisplayName("true 가 연속됐을 경우 예외처리")
    public void test() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Layer.of(Arrays.asList(false, false, true, true));
        });
    }

}