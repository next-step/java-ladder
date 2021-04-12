package ladder.domain;

import ladder.exception.InvalidNameSizeException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PersonTest {

    @DisplayName("Person 인스턴스 생성 여부 테스트")
    @Test
    void 생성() {
        // given
        String name = "wooji";

        // when
        Person person = Person.of(name);

        // then
        assertThat(person).isNotNull();
    }

    @DisplayName("Person 인스턴스의 이름 5자 초과일때 예외발생 테스트")
    @Test
    void 검증() {
        // given
        String name = "woojir";

        // when and then
        assertThatThrownBy(() -> Person.of(name))
                .isInstanceOf(InvalidNameSizeException.class)
                .hasMessage("이름이 5글자를 초과했습니다.");

    }
}