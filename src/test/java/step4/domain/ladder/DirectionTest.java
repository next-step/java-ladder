package step4.domain.ladder;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DirectionTest {

    @Test
    @DisplayName("첫번째 좌표 right-true를 생성할 수 있다.")
    void createFirstTrueTest() {

        // given
        boolean right = true;
        Direction expected = Direction.from(false, true);

        // when
        Direction result = Direction.first(right);

        // then
        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("equals, hashcode 테스트")
    void equalsHashCodeTest() {

        // given
        Direction direction = Direction.from(false, true);
        Direction copyDirection = Direction.from(false, true);

        // when & then
        assertThat(direction)
            .isEqualTo(copyDirection)
            .hasSameHashCodeAs(copyDirection);
    }

}