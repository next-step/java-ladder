package nextstep.ladder.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NameTest {
    
    @Test
    @DisplayName("이름은 반드시 존재해야 한다")
    void initName() {
        assertThatCode(() -> new Name("test")).doesNotThrowAnyException();
    }

    @Test
    void name_is_not_blank() {
        assertThatThrownBy(() -> new Name("")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void name_has_maxSize() {
        assertThatThrownBy(() -> new Name("junhyuck")).isInstanceOf(IllegalArgumentException.class);
    }
}