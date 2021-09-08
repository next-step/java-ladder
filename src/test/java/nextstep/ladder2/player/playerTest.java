package nextstep.ladder2.player;

import nextstep.ladder2.ErrorMessage;
import nextstep.ladder2.point.Point;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class playerTest {

    @Test
    @DisplayName("생성 테스트")
    void create(){
        Player player = Player.of("이름",5,10);
        
        assertThat(player.name()).isEqualTo("이름");
    }

    @Test
    @DisplayName("이름은 5자 이하로만 가능")
    void checkNameLength(){

        assertThatIllegalArgumentException().isThrownBy(
                ()->Player.of("123456",5,10)
        ).withMessageContaining(ErrorMessage.NAME_LENGTH.message());
    }

    @Test
    @DisplayName("플래이어 위치 이동하기")
    void movePlayerTest(){
        Player player = Player.of("james",1,2);

        player.move(Direction.LEFT);
        assertThat(player.index()).isEqualTo(0);

        player.move(Direction.RIGHT);
        assertThat(player.index()).isEqualTo(1);
    }

    @Test
    @DisplayName("바운더리 위치에서 플레이어 이동시 안움직임.")
    void movePlayerAtBoundaryTest(){
        Player player = Player.of("james",0,2);

        player.move(Direction.LEFT);
        assertThat(player.index()).isEqualTo(0);

    }
}