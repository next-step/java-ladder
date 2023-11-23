package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.InputMismatchException;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NameTest {

    @Test
    @DisplayName("이름의 길이가 5글자를 초과하면 에러를 던진다.")
    void 이름길이_확인() {
        assertThatThrownBy(() -> new Name("abcdef")).isInstanceOf(InputMismatchException.class);
    }
}
