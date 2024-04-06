package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LinesTest {

    @ParameterizedTest
    @DisplayName("라인들은 사다리 높이 개만큼 존재(5 => 5)")
    @ValueSource(ints = {5, 6})
    void lines_size(int heightSize) {
        Lines lines = new Lines(heightSize, 2);
        assertThat(lines.getLines().size()).isEqualTo(heightSize);
    }
}
