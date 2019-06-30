package ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class NameTest {
    @Test
    @DisplayName("5글짜 이하 이름 생성")
    void constructor() {
        String nameText = "pobi";
        Name name = new Name(nameText);
        assertThat(name.getName()).isEqualTo(nameText);
    }

    @Test
    @DisplayName("5글짜 이상 이름은 에러")
    void constructor_error() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> new Name("pobicrong"));
    }

    @Test
    @DisplayName("1글짜 미만 이름은 에러")
    void constructor_null() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> new Name(""));
    }
}
