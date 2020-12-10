package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TransverseLadderLineTest {

    private static final Participants participants = new Participants("pobi,crong,honux,jk");

    @Test
    @DisplayName("가로 사다리 생성 전략이 false가 들어가면, false를 반환한다.")
    void should_return_false_points() {
        //Given
        TransverseLadder ladder = new TransverseLadder(participants);

        //When
        Boolean line = ladder.getLine(() -> false);

        //Then
        assertThat(line).isFalse();
    }

    @Test
    @DisplayName("가로 사다리 생성 전략이 true가 들어가면, true를 반환한다.")
    void should_return_true_points() {
        //Given
        TransverseLadder ladder = new TransverseLadder(participants);

        //When
        Boolean line = ladder.getLine(() -> true);

        //Then
        assertThat(line).isTrue();
    }

}
