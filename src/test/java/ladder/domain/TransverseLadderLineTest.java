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
        TransverseLadder ladder = new TransverseLadder(participants.size());

        //When
        Boolean line = ladder.getLine(() -> false);

        //Then
        assertThat(line).isFalse();
    }

    @Test
    @DisplayName("가로 사다리 생성 전략이 true가 들어가면, true를 반환한다.")
    void should_return_true_points() {
        //Given
        TransverseLadder ladder = new TransverseLadder(participants.size());

        //When
        Boolean line = ladder.getLine(() -> true);

        //Then
        assertThat(line).isTrue();
    }

    @Test
    @DisplayName("연속되지 않는 사다리를 생성한다.")
    void should_return_non_continuous_points() {
        //Given & When
        TransverseLadder transverseLadder = new TransverseLadder(5);

        //Then
        for (int i = 1; i < transverseLadder.size(); i++) {
            assertNonContinuous(transverseLadder, i);
        }
    }

    private void assertNonContinuous(TransverseLadder ladder, int i) {
        if (ladder.existsLadder(i - 1)) {
            assertThat(ladder.existsLadder(i)).isFalse();
        }
    }

}
