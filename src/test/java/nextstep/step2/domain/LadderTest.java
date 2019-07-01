package nextstep.step2.domain;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {

    @Test
    @DisplayName("사다리 생성 테스트")
    void create_ladder() {
        assertThat(new Ladder(List.of()).getLines().size()).isEqualTo(0);
    }
}
