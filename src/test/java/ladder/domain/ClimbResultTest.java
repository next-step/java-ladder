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

    @DisplayName("Climb Result 결과 확인 테스트")
    @Test
    void awardMatchTest(){
        ClimbResult climbResult = ClimbResult.of(player, award);
        assertThat(climbResult.getAward()).isEqualTo(Award.from("fail"));
    }

    @DisplayName("Climb Result 플레이어 확인 테스트")
    @Test
    void playerMatchTest(){
        ClimbResult climbResult = ClimbResult.of(player, award);
        assertThat(climbResult.getPlayer()).isEqualTo(Player.from("crong"));
    }

}
