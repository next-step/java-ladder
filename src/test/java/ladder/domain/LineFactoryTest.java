package ladder.domain;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import ladder.exception.LineInvalidException;
import ladder.strategy.LineCreationStrategy;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LineFactoryTest {
    @Test
    @DisplayName("create()는 주어진 전략과 width로 Line을 생성한다")
    void create_widthToStrategy() {
        List<Boolean> expected = List.of(false, true, false, false);
        LineCreationStrategy strategy = countOfPersons -> List.of(false, true, false, false);
        int expectedWidth = 4;

        LineFactory factory = new LineFactory(strategy);
        Line line = factory.create(expectedWidth);
        assertThat(line.getLinks()).isEqualTo(expected);
    }

    @Test
    @DisplayName("전략이 빈 리스트를 반환하면 Line 생성 시 예외 발생")
    void create_ThrowsExceptionWhenStrategyReturnsEmptyList() {
        LineCreationStrategy strategy = countOfPersons -> List.of();
        LineFactory factory = new LineFactory(strategy);
        int width = 3;

        assertThatThrownBy(() -> factory.create(width))
            .isInstanceOf(LineInvalidException.class);
    }
}
