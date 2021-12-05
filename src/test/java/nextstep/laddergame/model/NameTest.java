package nextstep.laddergame.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import nextstep.laddergame.exception.InvalidNameException;

class NameTest {

    @DisplayName("이름 길이가 5글자를 초과하면 예외를 던진다")
    @Test
    void nameLengthTest() {
        assertThatThrownBy(() -> new Name("more than 5")).isInstanceOf(InvalidNameException.class);
    }

    @DisplayName("Name과 string이 주어졌을 때 그대로 반환하는지 검증")
    @Test
    void toStringTest() {
        String name = "pobi";
        assertThat(new Name(name).toString()).isEqualTo(name);
    }
}
