package nextstep.ladder.model.ladder;

import nextstep.ladder.model.player.Player;
import nextstep.ladder.model.player.Players;
import nextstep.ladder.strategy.TestPointGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderFactoryTest {

    @Test
    @DisplayName("사다리 팩토리로 사다리 생성 테스트")
    void createLadderWithFactory() {
        Players players = createTestPlayers();
        Height height = new Height(3);
        
        Ladder ladder = LadderFactory.create(players, height);
        
        assertThat(ladder).isNotNull();
        assertThat(ladder.getLines()).hasSize(3);
    }
    
    @Test
    @DisplayName("사다리 팩토리로 포인트 생성기를 사용한 사다리 생성 테스트")
    void createLadderWithCustomPointGenerator() {
        Players players = createTestPlayers();
        Height height = new Height(5);
        TestPointGenerator pointGenerator = new TestPointGenerator(false);
        
        Ladder ladder = LadderFactory.create(players, height, pointGenerator);
        
        assertThat(ladder).isNotNull();
        assertThat(ladder.getLines()).hasSize(5);

        for (int i = 0; i < players.count(); i++) {
            Position startPosition = new Position(i);
            assertThat(ladder.run(startPosition)).isEqualTo(startPosition);
        }
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
