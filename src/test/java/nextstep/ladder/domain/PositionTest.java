package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;

class PositionTest {
    @Test
    void createTest() {
        Position position = new Position(1);
        assertThat(position).isEqualTo(new Position(1));
    }

    @Test
    void invalidTest() {
        assertThatThrownBy(() -> new Position(-1)).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("value must be greater than or equal to 0");
    }

    @Test
    void moveByLeftTest() {
        Position position = new Position(1);

        position = position.moveBy(List.of(true, false));

        assertThat(position).isEqualTo(new Position(0));
    }

    @Test
    void moveByRightTest() {
        Position position = new Position(1);

        position = position.moveBy(List.of(false, true));

        assertThat(position).isEqualTo(new Position(2));
    }

    @Test
    void moveByStandTest() {
        Position position = new Position(1);

        position = position.moveBy(List.of(false, false));

        assertThat(position).isEqualTo(new Position(1));
    }

    @Test
    void getResultTest() {
        List<LadderResult> ladderResults = List.of(new LadderResult("10000"), new LadderResult("20000"));

        Position position = new Position(1);

        assertThat(position.getResult(ladderResults)).isEqualTo(new LadderResult("20000"));
    }
}
