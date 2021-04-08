package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.domain.Person;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PersonTests {

    @Test
    @DisplayName("사람 클래스 생성 테스트")
    void createPersonTest() {
        Person person1 = new Person("민수");
        Person person2 = new Person("민수");

        assertThat(person2).isEqualTo(person1);
    }

    @Test
    @DisplayName("사람 이름이 5글자 초과 에러 테스트")
    void moreThanFiveWordTest() {
        assertThatThrownBy(() -> new Person("5글자이상임"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("사람 이름 테스트")
    void personNameTest() {
        Person person = new Person("coby");
        assertThat(person.of()).isEqualTo("coby");
    }
}
