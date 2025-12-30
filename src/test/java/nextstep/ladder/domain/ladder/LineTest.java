package nextstep.ladder.domain.ladder;

import nextstep.ladder.domain.strategy.RandomLadderLineGenerateStrategy;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class LineTest {

    @Test
    void 라인_정상_생성(){
        Line line = new Line(3, new RandomLadderLineGenerateStrategy());
        assertThat(line.getLines()).hasSize(2); // 마지막은 무조건false 이기 때문에 크기 = 인원 수 -1
    }

}