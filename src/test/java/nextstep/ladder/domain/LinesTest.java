package nextstep.ladder.domain;

import nextstep.ladder.strategy.RandomDirectionStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.BDDAssertions.then;

public class LinesTest {

    @Test
    @DisplayName("라인들을 인자로 받아 모든 라인을 담는 객체를 생성한다.")
    public void create() throws Exception {
        //given
        Line firstLine = new Line(4, new RandomDirectionStrategy());
        Line secondLine = new Line(4, new RandomDirectionStrategy());
        Lines lines = new Lines(Arrays.asList(firstLine, secondLine));

        //when
        List<Line> result = lines.lines();

        then(result).hasSize(2);
    }
}
