package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class HeightsTest {

    @Test
    @DisplayName("사다리 높이 객체 생성 테스트")
    void createHeights() {
        Heights heights = Heights.from(5);

        assertThat(heights)
                .isInstanceOf(Heights.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1})
    @DisplayName("0보다 작은 수일 때 에러 테스트")
    void belowZeroErrorTest(int input) {
        assertThatThrownBy(() -> Heights.from(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("1씩 height 값 감소 테스트")
    void countDownTest() {
        Heights heights = Heights.from(3);
        heights.countDown();

        assertThat(heights)
                .usingRecursiveComparison()
                .isEqualTo(Heights.from(2));
    }

    @Test
    @DisplayName("높이가 1 이상인지 테스트")
    void hasMoreHeightsTest() {
        Heights heights = Heights.from(1);

        assertThat(heights.isOverMinimum())
                .isTrue();
    }

    @Test
    @DisplayName("높이가 1 보다 작은지 테스트")
    void hasNoMoreHeightsTest() {
        Heights heights = Heights.from(1);
        heights.countDown();

        assertThat(heights.isOverMinimum())
                .isFalse();
    }

}