package step3.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LineTest {


    @DisplayName("사람의 수만큼 Horizontal Line을 생성한다.")
    @ParameterizedTest
    @ValueSource(ints = {2, 3, 4, 5})
    void generateLineTest(int countOfPerson) {
        assertThat(new Line(countOfPerson).getPoints()).hasSize(countOfPerson - 1);
    }

    @DisplayName("연속적인 가로줄은 있을 수 없다.")
    @Test
    void shouldNotGenerateHorizontal() {
        assertThatThrownBy(() -> new Line(5, count -> List.of(true, true, true, false)))
                .isInstanceOf(IllegalStateException.class);
    }
}
