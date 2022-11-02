package ladder;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class AwardsTest {

    @Test
    void create() {
        Awards awards = new Awards(List.of(new Award("꽝"), new Award("100"), new Award("200")));
        Assertions.assertThat(awards.getAward(new Position(0)).getAward()).isEqualTo("꽝");
    }
}
