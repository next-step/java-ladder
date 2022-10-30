package ladder;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class AwardsTest {

    @Test
    void create() {
        Awards awards = Awards.of(List.of(Award.from("꽝"), Award.from("1000"), Award.from("2000"), Award.from("3000")));
        assertThat(awards).isEqualTo(Awards.of(List.of(Award.from("꽝"), Award.from("1000"), Award.from("2000"), Award.from("3000"))));
    }
}
