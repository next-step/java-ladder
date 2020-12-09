package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

class TransverseLadderTest {

    @Test
    @DisplayName("가로 사다리 선 생성시 false를 반환한다.")
    void should_return_false_points() {
        //Given
        TransverseLadder ladder = new TransverseLadder(10);

        //When
        Boolean point = ladder.getPoint(0, () -> false);

        //Then
        assertThat(point).isFalse();
    }

    @Test
    @DisplayName("가로 사다리 선 생성시 true를 반환한다.")
    void should_return_true_points() {
        //Given
        TransverseLadder ladder = new TransverseLadder(10);

        //When
        Boolean point = ladder.getPoint(0, () -> true);

        //Then
        assertThat(point).isTrue();
    }

}