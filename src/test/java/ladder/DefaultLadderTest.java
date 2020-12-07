package ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class DefaultLadderTest {

    @DisplayName("사디리높이가 1보다 작으면 exception 을 던진다")
    @Test
    void illegalHeight(){
        assertThatThrownBy( () -> new DefaultLadder(Arrays.asList("nio", "hoon", "mit"), 0))
                .isInstanceOf(IllegalArgumentException.class);
    }

}