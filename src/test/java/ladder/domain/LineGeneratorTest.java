package ladder.domain;

import java.util.List;
import java.util.Random;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static ladder.view.ResultView.result;

public class LineGeneratorTest {

    @Test
    void 랜덤값으로_인한_라인_겹침_해결() {
        LineGenerator lineGenerator = new LineGenerator(new AlwaysReturnTrue());
        Line line = lineGenerator.generate(3);
        result(List.of(line));
        Assertions.assertThat(line.getPoints()).containsSequence(new Point(true), new Point(null), new Point(false));
    }

    static class AlwaysReturnTrue extends Random {

        @Override
        public boolean nextBoolean() {
            return true;
        }
    }

}
