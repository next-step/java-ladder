package nextstep.ladder.view;

import nextstep.ladder.domain.Name;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class NameTest {
    @Test
    @DisplayName("정상적인 이름은 Name 객체 생성에 성공한다")
    void createValidName() {
        String validName = "pobi";
        Name name = Name.from(validName);
        assertThat(name).isNotNull();
    }

    @Test
    @DisplayName("이름이 null이면 예외가 발생한다")
    void createNameWithNull() {
        assertThatThrownBy(() -> Name.from(null))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("이름이 공백이면 예외가 발생한다")
    void createNameWithBlank() {
        assertThatThrownBy(() -> Name.from(" "))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("이름이 5자를 초과하면 예외가 발생한다")
    void createNameTooLong() {
        String longName = "abcdef";
        assertThatThrownBy(() -> Name.from(longName))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
