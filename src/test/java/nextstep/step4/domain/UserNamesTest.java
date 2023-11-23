package nextstep.step4.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class UserNamesTest {
    @Test
    @DisplayName("참여할 사람들의 이름을 입력으로 UserNames 객체를 생성할 수 있다.")
    void testUserNamesConstructor() {
        //given
        final String userNamesText = "pobi,honux,crong,jk";

        //when
        final UserNames userNames = new UserNames(userNamesText);

        //then
        assertThat(userNames).isNotNull();
    }

    @Test
    @DisplayName("참여할 사람들의 이름 중 5글자가 넘는 이름이 있으면, IllegalArgumentException이 발생한다.")
    void testUserNamesConstructorWithExceptionIfNameLengthIsLongerThan5() {
        //given
        final String userNamesText = "pobi,honux,crong,jk,pooobie";

        //when, then
        assertThatThrownBy(() -> new UserNames(userNamesText))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름은 5글자까지만 허용합니다.");
    }
}
