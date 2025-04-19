package nextstep.ladder.model.ladder;

import nextstep.ladder.model.player.Player;
import nextstep.ladder.model.player.Players;
import nextstep.ladder.strategy.TestPointGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {
    
    @ParameterizedTest
    @CsvSource({"0,true", "1,false", "2,true"})
    @DisplayName("고정된 값을 반환하는 포인트 생성기를 사용하여 라인 생성 테스트")
    void createLineWithTestGenerator(int position, boolean expected) {
        Players players = createTestPlayers();
        Line line = new Line(players, new TestPointGenerator(true));

        assertThat(line.hasLine(new Position(position))).isEqualTo(expected);
    }
    
    @ParameterizedTest
    @CsvSource({"0,false", "1,false", "2,false"})
    @DisplayName("항상 false를 반환하는 포인트 생성기로 라인 생성 테스트")
    void createLineWithFalseGenerator(int position, boolean expected) {
        Players players = createTestPlayers();
        Line line = new Line(players, new TestPointGenerator(false));

        assertThat(line.hasLine(new Position(position))).isEqualTo(expected);
    }
    
    @ParameterizedTest
    @CsvSource({"0,1", "1,0", "2,2"})
    @DisplayName("포인트 값에 따른 위치 이동 테스트")
    void movePositionTest(int initial, int expected) {
        Line line = new CustomLine();

        assertThat(line.movePosition(new Position(initial))).isEqualTo(new Position(expected));
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
