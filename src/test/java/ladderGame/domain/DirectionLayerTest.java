package ladderGame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class DirectionLayerTest {

    @Test
    @DisplayName("참가자 수로 생성된 층의 개수 확인")
    public void createByEntry() {
        DirectionLayer directionLayer = DirectionLayer.ofGenerator(5, count -> Arrays.asList(false, true, false, true));
        assertThat(directionLayer.getDirections()).containsExactly(Direction.STRAIGHT, Direction.RIGHT, Direction.LEFT, Direction.RIGHT, Direction.LEFT);
    }

    @Test
    @DisplayName("true 가 연속됐을 경우 예외처리")
    public void test() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            DirectionLayer.ofGenerator(5, count -> Arrays.asList(true, true, true, false));
        });
    }
}