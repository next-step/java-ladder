package nextstep.ladder2.player;

import nextstep.ladder2.ErrorMessage;
import nextstep.ladder2.point.Point;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.*;

class playerTest {

    @Test
    @DisplayName("생성 테스트")
    void create(){
        Player player = new Player("이름",new Point(5,10));
        
        assertThat(player.name()).isEqualTo("이름");
    }
    @Test
    @DisplayName("이름은 5자 이하로만 가능")
    void checkNameLength(){

        assertThatIllegalArgumentException().isThrownBy(
                ()->new Player("123456",new Point(5,10))
        ).withMessageContaining(ErrorMessage.NAME_LENGTH.message());

    }
}