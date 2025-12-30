package nextstep.ladder.domain.ladder;

import nextstep.ladder.domain.strategy.RandomLadderLineGenerateStrategy;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class LinesTest {

    @Test
    void 라인목록_정상_생성(){
        Lines lines = new Lines(
                new Line(3, new RandomLadderLineGenerateStrategy()),
                new Line(3, new RandomLadderLineGenerateStrategy()),
                new Line(3, new RandomLadderLineGenerateStrategy())
        );

        assertThat(lines.getLines()).hasSize(3);
    }

}