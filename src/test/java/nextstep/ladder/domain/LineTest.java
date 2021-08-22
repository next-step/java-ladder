package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class LineTest {

    @DisplayName("Line을 생성 할 수 있다")
    @Test
    void line() {
        // Given
        int countOfPerson = 3;
        Line line = Line.of(Arrays.asList(true, false, true));

        // When && Then
        assertThat(line.size()).isEqualTo(countOfPerson);
    }

    @DisplayName("이어지는 라인이 없어야한다")
    @Test
    void lineWithValidation() {
        // Given
        Line line = Line.of(Arrays.asList(true, false, true));

        // When
        List<Boolean> lines = line.getPoints();

        // Then
        assertAll("라인이 연속적인 true가 나오면 안된다..",
            () -> assertNotEquals(Arrays.asList(true, true, false), lines),
            () -> assertNotEquals(Arrays.asList(false, true, true), lines),
            () -> assertNotEquals(Arrays.asList(true, true, true), lines)
        );


    }


}
