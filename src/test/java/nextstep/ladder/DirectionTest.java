package nextstep.ladder;

import nextstep.ladder.domain.Direction;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class DirectionTest {

    @Test
    @DisplayName("좌표는 좌,우로 총 두가지 방향으로 이루어져있다.")
    void 좌표_좌_우(){
        List<Direction> points= Arrays.stream(Direction.values())
            .collect(Collectors.toList());
        assertThat(points.size()).isEqualTo(2);
    }
}
