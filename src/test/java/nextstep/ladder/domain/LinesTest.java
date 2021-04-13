package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.BDDAssertions.then;

public class LinesTest {

    @Test
    @DisplayName("사다리 높이를 인수로 해당 수 만큼의 라인을 생성한다.")
    public void create() throws Exception {
        //given
        Lines lines = new Lines(4, 5);

        //when
        List<Line> result = lines.lines();

        then(result).hasSize(5);
    }
}
