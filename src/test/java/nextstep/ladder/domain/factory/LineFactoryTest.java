package nextstep.ladder.domain.factory;

import nextstep.ladder.domain.Line;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LineFactoryTest {

    @DisplayName("사용자 수가 2보다 작으면 생성할 수 없다.")
    @ParameterizedTest
    @ValueSource(ints = { -1, 0, 1 })
    void canNotCreateLineIfLessThan2Count(int countOfPlayer) {
        assertThatThrownBy(() -> LineFactory.create(countOfPlayer, null))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("생성 전략이 존재하지 않으면 생성할 수 없다.")
    @Test
    void canNotCreateLineIfPointStrategyIsNull() {
        assertThatThrownBy(() -> LineFactory.create(3, null))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("라인을 생성할 수 있다.")
    @Test
    void canCreateLine() {
        assertThat(LineFactory.create(3, () -> true)).isInstanceOf(Line.class);
    }
}
