package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PartTest {

    @DisplayName("그리드의 로우를 구성하는 파트를 생성 시 짝수 인덱스면 Vertical 파트가 생성된다.")
    @Test
    void createTest1() {
        Part evenLineVerticalPart1 = Part.valueOf(0);
        Part evenLineVerticalPart2 = Part.valueOf(2);

        assertThat(evenLineVerticalPart1.isHorizontalLine()).isFalse();
        assertThat(evenLineVerticalPart2.isHorizontalLine()).isFalse();
    }

    @DisplayName("그리드의 로우를 구성하는 파트를 생성 시 홀수 인덱스면 Horizon 파트가 생성된다.")
    @Test
    void createTest2() {
        Part oddLineHorizonPart1 = Part.valueOf(1);
        Part oddLineHorizonPart2 = Part.valueOf(3);

        assertThat(oddLineHorizonPart1.isHorizontalLine()).isTrue();
        assertThat(oddLineHorizonPart2.isHorizontalLine()).isTrue();
    }

}
