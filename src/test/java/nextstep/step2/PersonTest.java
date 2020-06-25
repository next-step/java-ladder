package nextstep.step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PersonTest {

    @DisplayName("Person의 정적 템플릿 메소드 생성")
    @Test
    void create() {
        Person peter = Person.of("peter");
        assertThat(peter.getName()).isEqualTo("peter");
    }

    @DisplayName("빈칸을 입력시 에러 발생")
    @Test
    void checkIfNameIsValid() {
        assertThatThrownBy(() -> Person.of(""))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
