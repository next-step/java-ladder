package nextstep.ladder;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LadderTest {

    @ParameterizedTest
    @ValueSource(ints = {3, 10})
    @DisplayName("Ladder_생성_테스트")
    public void Ladder_생성_테스트(int height) {
        Participant participant = new Participant("test","test1","test2");
        Ladder ladder = new Ladder(height, participant, new RandomLineStrategy());

        assertThat(ladder.getLineSize()).isEqualTo(height);
    }


    @Test
    @DisplayName("사다리_높이_Validate_테스트")
    public void 사다리_높이_Validate_테스트() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> {
                    new Ladder(1);
                });
    }
}
