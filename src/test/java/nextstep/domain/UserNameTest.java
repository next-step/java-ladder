package nextstep.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class UserNameTest {

    @Test
    void 이름이_5글자를_초과하면_예외가_발생한다() {
        // given
        String userName = "player";

        // when & then
        assertThatThrownBy(() -> {
            new UserName(userName);
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름의 길이는 %d글자를 초과할 수 없습니다.", UserName.LENGTH_MAX);
    }
}
