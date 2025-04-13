package nextstep.ladder.model.ladder;

import nextstep.ladder.model.player.Player;
import nextstep.ladder.model.player.Players;
import nextstep.ladder.strategy.TestPointGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {
    
    @Test
    @DisplayName("고정된 값을 반환하는 포인트 생성기를 사용하여 라인 생성 테스트")
    void createLineWithTestGenerator() {
        Players players = createTestPlayers();
        Line line = new Line(players, new TestPointGenerator(true));

        assertThat(line.hasLine(new Position(0))).isTrue();
        assertThat(line.hasLine(new Position(1))).isFalse();
        assertThat(line.hasLine(new Position(2))).isTrue();
    }
    
    @Test
    @DisplayName("항상 false를 반환하는 포인트 생성기로 라인 생성 테스트")
    void createLineWithFalseGenerator() {
        Players players = createTestPlayers();
        Line line = new Line(players, new TestPointGenerator(false));

        assertThat(line.hasLine(new Position(0))).isFalse();
        assertThat(line.hasLine(new Position(1))).isFalse();
        assertThat(line.hasLine(new Position(2))).isFalse();
    }
    
    @Test
    @DisplayName("포인트 값에 따른 위치 이동 테스트")
    void movePositionTest() {
        Line line = new CustomLine();

        assertThat(line.movePosition(new Position(0))).isEqualTo(new Position(1));
        assertThat(line.movePosition(new Position(1))).isEqualTo(new Position(0));
        assertThat(line.movePosition(new Position(2))).isEqualTo(new Position(2));
    }
    
    private static Players createTestPlayers() {
        return Players.from(Arrays.asList(
                new Player("pobi"),
                new Player("crong"),
                new Player("honux"),
                new Player("jk")
        ));
    }

    private static class CustomLine extends Line {
        public CustomLine() {
            super(createTestPlayers(), new TestPointGenerator(false));
        }
        
        @Override
        public boolean hasLine(Position position) {
            return position.getValue() == 0;
        }
    }
} 
