package ladder;

import ladder.domain.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {

    private PlayersGroup playersGroup;

    @BeforeEach
    public void setupPlayersGroup() {
        List<String> playerList = Arrays.asList("aa", "bb", "cc", "dd", "ee");
        playersGroup = PlayersGroup.of(playerList);
    }

    @DisplayName("Ladder 객체 정상 생성 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 5, 10})
    public void makeLadderObject(int ladderHeight) {
        Ladder ladder = Ladder.buildLadder(playersGroup, ladderHeight, new RandomDrawingLineStrategy());

        assertThat(ladder.getLadderHeight())
                .isEqualTo(ladderHeight);

        assertThat(ladder.getLadderBluePrint().size())
                .isEqualTo(ladderHeight);

        assertThat(ladder.getLadderBluePrint().get(0).size())
                .isEqualTo(playersGroup.getPlayerCounts());
    }

    /*
    aa   bb   cc
    |----|    |
    |----|    |
    |----|    |
    bb   aa   cc
    형태의 사다리 테스트
     */
    @DisplayName("사다리에서 시작 위치(한 점)의 좌표가 주어지면, 사다리를 타고 그 결과 좌표를 리턴함")
    @Test
    public void climbLadder() {
        PlayersGroup playersGroup = PlayersGroup.of(Arrays.asList("aa", "bb", "cc"));
        DrawingLineStrategy drawingLineStrategy = new DrawingLineStrategy() {
            @Override
            public List<Point> drawLine(int playerCounts) {
                List<Point> points = Arrays.asList(new Point(0, Direction.RIGHT),
                        new Point(1, Direction.LEFT),
                        new Point(2, Direction.DOWN));
                return points;
            }
        };

        Ladder ladder = Ladder.buildLadder(playersGroup, 3, drawingLineStrategy);
        int resultOfFirst = ladder.climb(0);
        int resultOfSecond = ladder.climb(1);
        int resultOfThird = ladder.climb(2);

        assertThat(resultOfFirst).isEqualTo(1);
        assertThat(resultOfSecond).isEqualTo(0);
        assertThat(resultOfThird).isEqualTo(2);
    }
}

