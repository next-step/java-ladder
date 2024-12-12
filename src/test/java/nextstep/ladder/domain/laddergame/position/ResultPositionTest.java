package nextstep.ladder.domain.laddergame.position;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Map;

class ResultPositionTest {

    @Test
    void create() {
        ResultPosition resultPosition = new ResultPosition();

        Assertions.assertThat(resultPosition).isNotNull();
    }

    @Test
    void create_map() {
        ResultPosition resultPosition = new ResultPosition(Map.of(0, 3));

        Assertions.assertThat(resultPosition).isNotNull();
    }

    @Test
    void getFinishPosition() {
        ResultPosition resultPosition = new ResultPosition(Map.of(0, 3));

        Assertions.assertThat(resultPosition.getFinishPosition(0)).isEqualTo(3);
    }
}