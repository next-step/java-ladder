package nextstep.ladder2.ladder;

import nextstep.ladder2.domain.ladder.Line;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    public void 지정갯수만큼_라인을_생성할수있다(int size) {
        Line line = new Line(size);
        assertThat(line.size()).isEqualTo(size);

        System.out.println(line);
    }
}
