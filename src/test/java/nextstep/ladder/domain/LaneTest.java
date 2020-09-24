package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class LaneTest {

    @Test
    @DisplayName("팩토리 메소드 정상 작동")
    void of() {
        int countOfPerson = 4;
        assertNotNull(Lane.of(countOfPerson, 0));
        assertNotNull(Lane.of(countOfPerson, 2));
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 4, 5})
    @DisplayName("index 범위가 유효한지 검사")
    void of_validateRange(int index) {
        int countOfPerson = 4;
        assertThatIllegalArgumentException().isThrownBy(() ->
                Lane.of(countOfPerson, index)
        );
    }
}
