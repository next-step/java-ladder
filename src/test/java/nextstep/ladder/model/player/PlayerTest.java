package nextstep.ladder.model.player;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class PlayerTest {
    
    @Test
    @DisplayName("플레이어 생성 테스트")
    void createPlayer() {
        Player player = new Player("pobi");
        assertThat(player.getName()).isEqualTo("pobi");
    }
    
    @Test
    @DisplayName("플레이어 동등성 테스트")
    void playerEquality() {
        Player player1 = new Player("pobi");
        Player player2 = new Player("pobi");
        Player player3 = new Player("crong");
        
        assertThat(player1).isEqualTo(player2);
        assertThat(player1).isNotEqualTo(player3);
    }
} 
