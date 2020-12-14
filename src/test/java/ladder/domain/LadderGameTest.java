package ladder.domain;

import org.junit.jupiter.api.DisplayName;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LadderGameTest {

    private static final int MIN_LADDER_HEIGHT = 1;


    @DisplayName("사다리 최소 높이(1)보다 작은 경우 Exception Test")
    @ParameterizedTest
    @ValueSource(ints = {0, -2})
    void illegalPlayerNameExceptionTest(int maxHeight){

        assertThatIllegalArgumentException().isThrownBy(() -> {

            new LadderGame().build(3, maxHeight);

        }).withMessageContaining("최소 사다리 높이는 "+MIN_LADDER_HEIGHT+" 입니다.");
    }

}
