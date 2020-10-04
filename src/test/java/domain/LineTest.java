package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LineTest {
    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 1})
    void 인풋유효성_테스트(int countOfPerson) {
        assertThatThrownBy(() -> {
            new Line(countOfPerson);

        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Input size");
    }

    @DisplayName("생성된 포인트 개수 테스트")
    @Test
    void point_size_test() {
        assertThat(new Line(5).getPoints().size()).isEqualTo(5);
    }

}
