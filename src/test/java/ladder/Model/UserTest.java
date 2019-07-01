package ladder.Model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UserTest {

    @Test
    @DisplayName("사용자 이름 글자수 5글자 이상 오류 테스트")
    void nameException(){
        Assertions.assertThatThrownBy(() -> new User("테스트중이름"))
                .isInstanceOf(IllegalStateException.class)
                .hasMessage("사다리 게임 이용자의 이름은 다섯글자를 넘을 수 없습니다.");
    }

}
