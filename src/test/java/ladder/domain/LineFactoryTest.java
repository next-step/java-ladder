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
    @DisplayName("create()는 주어진 전략과 height, width로 Ladder를 생성한다")
    void create_widthToStrategy() {
        List<Boolean> line = List.of(false, true, false, false);
        LineCreationStrategy strategy = countOfPersons -> line;

        int height = 3;
        int width = 5;

        Ladder ladder = new LineFactory(height, width, strategy).createLadder();
        assertThat(ladder.getHeight()).isEqualTo(height);
        assertThat(ladder.getWidth()).isEqualTo(width);
    }

    @Test
    @DisplayName("전략이 빈 리스트를 반환하면 Line 생성 시 예외 발생")
    void create_ThrowsExceptionWhenStrategyReturnsEmptyList() {
        LineCreationStrategy strategy = countOfPersons -> List.of();
        LineFactory factory = new LineFactory(5, 5, strategy);

        assertThatThrownBy(factory::createLadder)
            .isInstanceOf(LineInvalidException.class);
    }
}
