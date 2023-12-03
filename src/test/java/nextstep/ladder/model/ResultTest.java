package nextstep.ladder.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ResultTest {
    @Test
    @DisplayName("결과는 ")
    void test1() {
        //given
        String name = "123456";
        //then
        assertThatThrownBy(() -> new Name(name))
                .hasMessageContaining("이름은 5글자를 초과할 수 없습니다.");
    }

    @Test
    @DisplayName("사람이름은 공백 불가능")
    void test2() {
        //given
        String name = "";
        //then
        assertThatThrownBy(() -> new Name(name))
                .hasMessageContaining("이름은 공백일 수 없습니다.");
    }
}