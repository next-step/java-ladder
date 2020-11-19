package nextstep.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class CountOfPersonTest {
    @Test
    @DisplayName("CountOfPerson 생성시에 value값이 2보다 작은 숫자면 throw Exception")
    void createTest() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new CountOfPerson(1));
    }
}
