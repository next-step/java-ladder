package step4_ladderGame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PlayersTest {

    @DisplayName("입력 받은 이름 만큼 플레이어를 만든다.")
    @Test
    void testCase() {
        Players players = Players.of(new String[]{"LG", "SKT", "KT"});

        assertThat(players.size()).isEqualTo(3);
        assertThat(players.getPlayer(0)).isEqualTo(Player.of("LG", 0));
    }

    @DisplayName("사다리 게임을 완료한 다음 플레이어 이름을 반환한다.")
    @Test
    void testCase2() {
        Players players = Players.of(new String[]{"LG", "SKT", "KT", "CJ"});
        Ladder ladder = createLadder();

        Players movePlayer = players.play(ladder);

        assertThat(movePlayer.getPlayer(0)).isEqualTo(Player.of("LG", 2)); // KT
        assertThat(movePlayer.getPlayer(1)).isEqualTo(Player.of("SKT", 1));  // SKT
        assertThat(movePlayer.getPlayer(2)).isEqualTo(Player.of("KT", 0)); // LG
        assertThat(players.getPlayer(3)).isEqualTo(Player.of("CJ", 3)); // CJ
    }

    Ladder createLadder() {
        List<LadderLine> ladderLines =
                List.of(createLadderLine(Direction.RIGHT, Direction.LEFT, Direction.STOP, Direction.STOP)
                        , createLadderLine(Direction.STOP, Direction.RIGHT, Direction.LEFT, Direction.STOP)
                        , createLadderLine(Direction.RIGHT, Direction.LEFT, Direction.STOP, Direction.STOP));
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