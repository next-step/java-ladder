package step4_ladderGame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {

    @DisplayName("입력한 높이 만큼 사다리를 생성한다.")
    @Test
    void testCase1() {
        Ladder ladder = Ladder.of(5, 5, RandomPointStrategy.getInstance());

        assertThat(ladder.size()).isEqualTo(5);
    }

    @DisplayName("사다리에 따라 플레이어를 이동시킨다.")
    @Test
    void testCase2() {
        Player player = Player.of("LG", 0);
        Ladder ladder = createLadder();

        Player movePlayer = ladder.move(player);

        assertThat(movePlayer.getPosition()).isEqualTo(Position.of(1));
    }

    Ladder createLadder() {
        List<LadderLine> ladderLines =
                List.of(createLadderLine(Direction.RIGHT, Direction.LEFT, Direction.STOP, Direction.RIGHT)
                        , createLadderLine(Direction.STOP, Direction.LEFT, Direction.RIGHT, Direction.LEFT)
                        , createLadderLine(Direction.RIGHT, Direction.LEFT, Direction.STOP, Direction.RIGHT));
        return Ladder.of(ladderLines);
    }

    LadderLine createLadderLine(Direction first, Direction second, Direction third, Direction fourth) {
        List<Stair> stairList = List.of(Stair.of(0, createPoint(first)),
                Stair.of(1, createPoint(second)),
                Stair.of(2, createPoint(third)),
                Stair.of(3, createPoint(fourth)));
        return LadderLine.of(stairList);
    }

    Point createPoint(Direction direction) {
        if (direction == Direction.LEFT) {
            return Point.of(true, false);
        }
        if (direction == Direction.RIGHT) {
            return Point.of(false, true);
        }
        return Point.of(false, false);
    }


}