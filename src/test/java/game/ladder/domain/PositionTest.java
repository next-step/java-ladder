package game.ladder.domain;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PositionTest {

    @Test
    public void 만들기() {
        final int expected = 2;
        Position position = new Position(expected);

        assertThat(position.getValue()).isEqualTo(expected);
    }

    @Test(expected = IllegalArgumentException.class)
    public void MIN_POSITION_보다_작은값_생성() {
        final int lower = Position.MIN_VALUE - 1;

        new Position(lower);
    }

    @Test
    public void 동등성_테스트() {
        final int value = 3;

        final Position position1 = new Position(value);
        final Position position2 = new Position(value);

        assertThat(position1).isEqualTo(position2);
    }

    @Test
    public void 정렬하기() {
        final Position position1 = new Position(1);
        final Position position2 = new Position(2);
        final Position position3 = new Position(3);

        List<Position> positions = Arrays.asList(position3, position1, position2);

        Collections.sort(positions);

        assertThat(positions).containsSequence(position1, position2, position3);
    }

}