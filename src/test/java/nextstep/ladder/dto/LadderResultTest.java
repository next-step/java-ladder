package nextstep.ladder.dto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

public class LadderResultTest {

    @Test
    public void 입력한_결과를_컴마단위로_분리한다() {
        assertThat(new LadderResult("꽝,당첨")).isEqualTo(new LadderResult(List.of("꽝", "당첨")));
    }
}
