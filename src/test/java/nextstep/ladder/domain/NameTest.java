package nextstep.ladder.domain;

import nextstep.ladder.exception.ExceedNameLengthException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NameTest {

    @Test
    @DisplayName("실패 - 참여자의 이름이 5자를 초과할 경우 예외가 발생 한다.")
    void fail_name_length_over() {
        String name = "abcdef";

        Assertions.assertThatThrownBy(() -> new Name(name))
                .isInstanceOf(ExceedNameLengthException.class)
                .hasMessage("참여자의 이름은 5자 이하로 입력하세요.");
    }

}
