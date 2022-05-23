package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NameTest {

    @Test
    @DisplayName("이름이 5글자를 넘어가면 예외가 발생한다.")
    void 이름_생성_예외(){
        assertThatThrownBy(()->new Name("123456"))
                .isInstanceOf(IllegalArgumentException.class);
    }

}