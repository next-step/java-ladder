package nextstep.ladder.domain.laddergame.position;

import nextstep.ladder.domain.ladder.Ladder;
import nextstep.ladder.domain.ladder.LadderTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class PositionsTest {

    @Test
    void create() {
        Positions positions = new Positions();

        Assertions.assertThat(positions).isNotNull();
    }

    @Test
    void add() {
        Ladder ladder = LadderTest.getLadder();

        Positions positions = new Positions();
        int playerPosition = 3;
        positions.add(ladder.getLines(), playerPosition);

        List<Position> result = positions.getPositions();

        Assertions.assertThat(result.get(0).getPosition()).isEqualTo(2);
        Assertions.assertThat(result.get(1).getPosition()).isEqualTo(3);
        Assertions.assertThat(result.get(2).getPosition()).isEqualTo(3);
        Assertions.assertThat(result.get(3).getPosition()).isEqualTo(3);
    }

}