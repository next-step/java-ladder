package nextstep.ladder.module;


import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class NameTest {
    @Test
    @DisplayName("이름이 비어있으면 에러")
    void givenEmptyName_whenCreateName_thenThrowException() {
        assertThatThrownBy(() -> new Name("")).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름은 빈 문자열이 될 수 없습니다.");
    }

    @Test
    @DisplayName("이름이 공백이면 에러")
    void givenBlankName_whenCreateName_thenThrowException() {
        assertThatThrownBy(() -> new Name(" ")).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름은 공백이 될 수 없습니다.");
    }

    @Test
    @DisplayName("이름이 5자를 초과하면 에러")
    void givenNameGreaterThanFive_whenCreateName_thenThrowException() {
        assertThatThrownBy(() -> new Name("123456")).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름은 5자를 초과할 수 없습니다.");
    }   

    @Test
    @DisplayName("이름이 5자 이하면 통과")
    void givenNameLessThanOrEqualToFive_whenCreateName_thenPass() {
        assertThat(new Name("bt").value()).isEqualTo("bt");
    }
    
}
