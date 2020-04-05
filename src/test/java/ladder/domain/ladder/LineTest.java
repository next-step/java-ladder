package ladder.domain.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LineTest {
    @Test
    @DisplayName("인접 해서 사다리 바가 있을 수 없음")
    void adjacentTest(){
        assertThatThrownBy(()->Line.of(true,true,false,true))
                .isInstanceOf(RuntimeException.class);
    }

}
