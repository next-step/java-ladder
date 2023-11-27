package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LadderTest {

    @Test
    @DisplayName("사람들의 이름의 길이로 사다리의 폭을 결정한다.")
    void determine_ladder_width() {
        // given
        List<String> names = List.of("pobi", "honux", "crong", "jk");

        // when
        Ladder result = new Ladder(names);

        // then
        assertThat(result).isEqualTo(new Ladder(5));
    }
}
