package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LadderMemberAndResultTest {

    @DisplayName("사다리 참가자수와 결과수가 동일하지 않으면 exception 을 던진다")
    @Test
    void illegalMembersAndResults(){
        assertThatThrownBy( () -> new LadderMemberAndResult(Arrays.asList("nio", "hoon", "mit"), Arrays.asList("0", "1000")))
                .isInstanceOf(IllegalArgumentException.class);
    }

}