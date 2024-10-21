package step2.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/*
- 참여 인원의 이름을 생성한다.
- 참여 인원의 이름은 5자를 초과하면 안된다.
*/
public class NameTest {

    @DisplayName("참여 인원의 이름을 생성한다.")
    @Test
    void createNameTest() {
        Name name = Name.createName("test");
        assertThat(name.getName()).isEqualTo("test");
    }

    @DisplayName("참여 인원의 이름은 5자를 초과하면 안된다. ")
    @Test
    void createNameMustNotOverFiveTest() {
        assertThatThrownBy(() -> Name.createName("testtest"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("참여 인원의 이름은 5자를 초과하면 안됩니다.");
    }
}
