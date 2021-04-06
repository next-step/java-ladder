package step4_ladderGame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LadderLineTest {

    @DisplayName("플레이어 수에 따라 Point를 생성한다.")
    @Test
    void testCase1() {
        int playerCount = 5;

        LadderLine line = LadderLine.of(playerCount, RandomPointStrategy.getInstance());

        assertThat(line.size()).isEqualTo(5);
    }

    @DisplayName("stiar의 Point의 Direction에 따라 플레이어를 오른쪽으로 이동시킨다.")
    @Test
    void testCase2() {
        Player player = Player.of("LG", 0);
        LadderLine ladderLine = createLadderLine();

        Player movePlayer = ladderLine.move(player);

        assertThat(movePlayer.getPosition()).isEqualTo(Position.of(1));
    }

    @DisplayName("stiar의 Point의 Direction에 따라 플레이어를 왼쪽으로 이동시킨다.")
    @Test
    void testCase3() {
        Player player = Player.of("LG", 1);
        LadderLine ladderLine = createLadderLine();

        Player movePlayer = ladderLine.move(player);

        assertThat(movePlayer.getPosition()).isEqualTo(Position.of(0));
    }

    @DisplayName("stiar의 Point의 Direction에 따라 플레이어를 정지 시킨다.")
    @Test
    void testCase4() {
        Player player = Player.of("LG", 2);
        LadderLine ladderLine = createLadderLine();

        Player movePlayer = ladderLine.move(player);

        assertThat(movePlayer.getPosition()).isEqualTo(Position.of(2));
    }

    LadderLine createLadderLine() {
        List<Stair> stairList = List.of(Stair.of(0, Point.of(false, true)),
                Stair.of(1, Point.of(true, false)),
                Stair.of(2, Point.of(false, false)),
                Stair.of(3, Point.of(false, true)));
        return LadderLine.of(stairList);
    }
}