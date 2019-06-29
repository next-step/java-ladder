package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class PointTest {

    @Test
    @DisplayName("Point 객체는 싱글톤으로 관리")
    void of() {

        assertThat(Point.of(true)).isSameAs(Point.of(true));
        assertThat(Point.of(false)).isSameAs(Point.of(false));
    }

    @ParameterizedTest(name = "Point 존재여부는 스텝과 라인번호의 합에 따라 결정")
    @CsvSource(value = {
            "0,0",
            "0,1",
            "1,0",
            "1,1"
    })
    void ofIsOdd(int step, int lineNumber) {

        boolean expected = (step + lineNumber) % 2 == 0;
        assertThat(Point.of(step, lineNumber)).isSameAs(Point.of(expected));
    }
}