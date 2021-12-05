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
}
