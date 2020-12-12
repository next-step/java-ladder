package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class ClimbResultTest {

    private Player player;

    private Award award;

    @BeforeEach
    public void init(){
        player = Player.from("crong");
        award = Award.from("fail");
    }

    @DisplayName("Climb Result 생성 테스트")
    @Test
    void climbResultConstructorTest(){
        assertThat(ClimbResult.of(player,award)).isEqualTo(ClimbResult.of(player,award));
    }
}
