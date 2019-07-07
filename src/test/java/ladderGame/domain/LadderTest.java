package ladderGame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {

    @Test
    @DisplayName("사다리 생성")
    public void create() {
        Ladder ladder = Ladder.of(3, 5);
        assertThat(ladder.size()).isEqualTo(5);
    }

    @Test
    @DisplayName("사다리 타기")
    public void rideLadder() {

        Ladder ladder = Ladder.ofDirections(Arrays.asList(
                DirectionLayer.ofGenerator(3, count -> Arrays.asList(Direction.RIGHT, Direction.LEFT, Direction.STRAIGHT)),
                DirectionLayer.ofGenerator(3, count -> Arrays.asList(Direction.STRAIGHT, Direction.RIGHT, Direction.LEFT)),
                DirectionLayer.ofGenerator(3, count -> Arrays.asList(Direction.RIGHT, Direction.LEFT, Direction.STRAIGHT))
        ));
        assertThat(ladder.ride(new Position(0))).isEqualTo(new Position(2));
        assertThat(ladder.ride(new Position(1))).isEqualTo(new Position(1));
        assertThat(ladder.ride(new Position(2))).isEqualTo(new Position(0));
    }
}