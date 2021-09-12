package nextstep.ladder.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class NameTest {
    @Test
    @DisplayName("이름 길이가 5자를 넘으면 익셉션")
    public void nameLengthLimit() {
        new Name("12345");
        assertThatThrownBy(() -> {
            new Name("123456");
        }).isInstanceOf(IllegalArgumentException.class);
    }
}