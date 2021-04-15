package ladder.domain;

import ladder.exception.InvalidNameSizeException;
import ladder.exception.ParticipantListNullPointerException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

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

    @DisplayName("Person 인스턴스에 all 입력시 예외처리 테스트")
    @Test
    void 검증_all() {
        // given
        String name = "all";

        // when and then
        assertThatThrownBy(() -> Person.of(name))
                .isInstanceOf(InvalidIdentifierNameException.class)
                .hasMessage("all 이란 이름은 사용할 수 없습니다.");

    }

    @DisplayName("Person 인스턴스의 이름을 반환하는 기능 테스트")
    @Test
    void 반환() {
        // given
        String expected = "wooji";

        // when
        Person person = Person.of(expected);
        String actual = person.getName();

        assertThat(actual).isEqualTo(expected);
    }
}