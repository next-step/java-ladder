package ladder.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class UserTest {

    @Test
    @DisplayName("사용자 이름 글자수 5글자 이상 오류 테스트")
    void nameValidation() {
        Assertions.assertThatThrownBy(() -> new User("leedat"))
                  .isInstanceOf(IllegalStateException.class)
                  .hasMessage("사다리 게임 이용자의 이름은 다섯글자를 넘을 수 없습니다.");
    }

    @Test
    @DisplayName("사용자 이름의 영문을 제외한 문자 포함시 오류 테스트")
    void numberValidation() {
        Assertions.assertThatThrownBy(() -> new User("lee테"))
                  .isInstanceOf(IllegalStateException.class)
                  .hasMessage("사다리 게임 이용자의 이름은 영문으로만 입력 할 수 있습니다.");
    }

    @Test
    @DisplayName("결과 보고싶은 사용자 입력 란에 all 입력 여부 테스트")
    void allPrintUserSign(){
        User user = new User("all");
        assertThat(user.isAllPrintSignUser()).isTrue();
    }

}
