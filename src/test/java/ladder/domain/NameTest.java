package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class NameTest {

    @Test
    @DisplayName("이름 생성이 정상적으로 잘 되어있는지 확인")
    void createNameTest() {
        Name name = new Name("tom");
        assertThat(name.name()).isEqualTo("tom");
    }

    @Test
    @DisplayName("이름이 5자 초과되면 에러코드 내는지 확인")
    void createNameExceedFiveErrorTest() {
        assertThatThrownBy(() -> {
            Name name = new Name("test12345");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이름은 5글자를 초과할 수 없습니다.");
    }

    @Test
    @DisplayName("이름이 빈칸이면 에러코드 내는지 확인")
    void createNameZeroLengthErrorTest() {
        assertThatThrownBy(() -> {
            Name name = new Name("");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이름은 빈칸을 넣을 수 없습니다.");
    }

}
