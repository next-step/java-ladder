package nextstep.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

public class NameTest {
    @Test
    @DisplayName("이름의 유효한 길이는 1글자 이상 5글자 이하")
    void invalidNameTest() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> Name.valueOf("123456"));
    }
}
