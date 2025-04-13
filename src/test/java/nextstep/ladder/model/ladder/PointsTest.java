package nextstep.ladder.model.ladder;

import nextstep.ladder.model.player.Player;
import nextstep.ladder.model.player.Players;
import nextstep.ladder.strategy.TestPointGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class PointsTest {
    
    @Test
    @DisplayName("Players에 따른 Points 생성 테스트")
    void createPoints() {
        Players players = createPlayersWithCount(4);
        Points points = Points.create(players, new TestPointGenerator(true));

        assertThat(points.size()).isEqualTo(3);
    }
    
    @Test
    @DisplayName("연속된 가로 라인 생성 방지 규칙 테스트")
    void preventConsecutiveTruePoints() {
        Players players = createPlayersWithCount(5);
        Points points = Points.create(players, new TestPointGenerator(true));

        assertThat(points.hasLine(new Position(0))).isTrue();
        assertThat(points.hasLine(new Position(1))).isFalse();
        assertThat(points.hasLine(new Position(2))).isTrue();
        assertThat(points.hasLine(new Position(3))).isFalse();
    }
    
    @Test
    @DisplayName("포지션 유효성 검사 테스트")
    void positionValidation() {
        Players players = createPlayersWithCount(3);
        Points points = Points.create(players, new TestPointGenerator(false));

        assertThat(points.isValidPosition(new Position(0))).isTrue();
        assertThat(points.isValidPosition(new Position(1))).isTrue();

        assertThat(points.hasLine(new Position(2))).isFalse();
        assertThat(points.hasLine(new Position(10))).isFalse();
    }
    
    private Players createPlayersWithCount(int count) {
        Player[] players = new Player[count];
        for (int i = 0; i < count; i++) {
            players[i] = new Player("player" + (i + 1));
        }
        return Players.from(Arrays.asList(players));
    }
} 
