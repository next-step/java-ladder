package step2.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/*
- 참여 인원의 이름을 생성한다.
- 참여 인원의 이름은 5자를 초과하면 안된다.
- 이름이 일치하는지 체크한다.
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

    @DisplayName("이름이 일치하는지 체크한다.")
    @ParameterizedTest
    @CsvSource(value = {"test:true", "test2:false"}, delimiter = ':')
    void checkNameTest(String personName, boolean b) {
        Name name = Name.createName("test");
        assertThat(name.checkName(personName)).isEqualTo(b);
    }
}
