package nextstep.ladder.domian;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Names;
import nextstep.ladder.domain.Results;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ResultsTest {

    private Results result;

    @DisplayName("결과를 생성한다.")
    @Test
    void 결과를_생성한다() {
        result = new Results("꽝,5000,꽝,3000");
    }

    @DisplayName("결과는 참여자 수와 같아야 한다.")
    @Test
    void 결과는_참여자_수와_같아야_한다() {
        result = new Results("꽝,5000,꽝,3000");
        int size = 4;
        assertThat(result.validateSize(4)).isTrue();
    }

    @DisplayName("지정한 결과만 가져온다.")
    @Test
    void 지정한_결과만_가져온다() {
        result = new Results("꽝,5000,꽝,3000");
        assertThat(result.get(1).value()).isEqualTo("5000");
    }

    @DisplayName("당첨결과를 가져온다.")
    @Test
    void 당첨결과를_가져온다() {
        Names names = new Names("a,b");
        Ladder ladder = new Ladder(2, names.size(), () -> true);
        result = new Results("꽝,5000");
        assertThat(result.of(names, ladder).get(names.get(0)).value()).isEqualTo("꽝");
    }
}
