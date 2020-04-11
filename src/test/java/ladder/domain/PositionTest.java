package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class PositionTest {
    private Position position;

    @BeforeEach
    void setUp() {
        position = Position.of(10);
    }

    @DisplayName("정상 실행")
    @Test
    void create() {
        assertThat(position.getPosition()).isEqualTo(10);
        assertThat(position).isEqualTo(Position.of(10));
    }

    @DisplayName("Position 은 음수 일 수 없다.")
    @ParameterizedTest
    @ValueSource(ints = {-1, -10, -100})
    void exceptByCreation(int input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
           Position.of(input);
        });
    }

    @DisplayName("Position 의 전진 후진 테스트")
    @Test
    void forwardAndBack() {
        assertThat(position.back()).isEqualTo(Position.of(9));
        assertThat(position.forward()).isEqualTo(Position.of(11));
    }

    @DisplayName("정상 실행")
    @Test
    void goe() {
        assertThat(position.goe(10)).isTrue();
        assertThat(position.goe(15)).isFalse();
        assertThat(position.goe(7)).isTrue();
    }
}
