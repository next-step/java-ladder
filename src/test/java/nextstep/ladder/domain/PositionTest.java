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
    void moveByTest() {
        Position position = new Position(1);

        position = position.moveBy(List.of(false, true));

        assertThat(position).isEqualTo(new Position(2));
    }

    @Test
    void getResultTest() {
        List<Result> results = List.of(new Result("10000"), new Result("20000"));

        Position position = new Position(1);

        assertThat(position.getResult(results)).isEqualTo(new Result("20000"));
    }
}
