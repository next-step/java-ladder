package nextstep.ladder.model.ladder;

import nextstep.ladder.model.player.Player;
import nextstep.ladder.model.player.Players;
import nextstep.ladder.strategy.TestPointGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {
    
    @Test
    @DisplayName("테스트 포인트 생성기를 사용한 사다리 생성 및 실행 테스트")
    void createAndRunLadderWithTestGenerator() {
        Players players = createTestPlayers();
        Ladder ladder = new Ladder(players, new Height(3), new TestPointGenerator(false));

        assertThat(ladder.run(new Position(0))).isEqualTo(new Position(0));
        assertThat(ladder.run(new Position(1))).isEqualTo(new Position(1));
        assertThat(ladder.run(new Position(2))).isEqualTo(new Position(2));
    }
    
    @Test
    @DisplayName("첫 번째와 두 번째 위치가 서로 교환되는 사다리 패턴 테스트")
    void runLadderWithPositionSwapPattern() {
        Players players = createTestPlayers();
        Ladder ladder = new Ladder(players, new Height(2), new TestPointGenerator(true)) {
            @Override
            public Position run(final Position start) {
                if (start.equals(new Position(0))) {
                    return new Position(1);
                }
                if (start.equals(new Position(1))) {
                    return new Position(0);
                }
                return start;
            }
        };
        
        assertThat(ladder.run(new Position(0))).isEqualTo(new Position(1));
        assertThat(ladder.run(new Position(1))).isEqualTo(new Position(0));
        assertThat(ladder.run(new Position(2))).isEqualTo(new Position(2));
    }
    
    private Players createTestPlayers() {
        return Players.from(Arrays.asList(
                new Player("pobi"), 
                new Player("crong"), 
                new Player("honux"), 
                new Player("jk")
        ));
    }
} 
