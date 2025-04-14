package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PlayerTest {

    @Test
    @DisplayName("플레이어 생성")
    void createPlayer() {
        assertThat(new Player("홍길동")).isNotNull();
    }

    @Test
    @DisplayName("플레이어 이름은 최대 5글자이다")
    void playerNameMaxLength() {
        assertThatThrownBy(() -> new Player("123456"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("이름은 최대 5글자입니다.");
    }
    

}
