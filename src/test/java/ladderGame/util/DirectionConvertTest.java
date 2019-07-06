package ladderGame.util;

import ladderGame.domain.Direction;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.*;

class DirectionConvertTest {

    @Test
    @DisplayName("방향으로 변환")
    void parse() {
        List<Direction> parse = DirectionConvert.newInstance().parse(Arrays.asList(false, true, false, true, false));
        assertThat(parse).containsExactly(Direction.RIGHT, Direction.LEFT, Direction.RIGHT, Direction.LEFT);
    }

    @Test
    @DisplayName("중복적으로 Rung 생성시 변환 예외처리")
    void parseException() {

        assertThatIllegalArgumentException().isThrownBy(() -> {
            DirectionConvert.newInstance().parse(Arrays.asList(false, true, true, true, false));
        });
    }


}