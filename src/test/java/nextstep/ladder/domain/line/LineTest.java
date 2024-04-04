package nextstep.ladder.domain.line;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class LineTest {

    @Test
    void 한_라인은_사람의_수보다_하나_작게_생성되어야_한다() {
        int countOfPerson = 6;
        Line line = new Line(countOfPerson);

        assertThat(line.getPoints().size()).isEqualTo(countOfPerson - 1);
    }

    @Test
    void 이전_사다리_상태가_True라면_다음_상태는_True일수_없다() {
        Line line = new Line(List.of(true, true));

        assertThat(line.getPoints().get(0).isPointFalse()).isEqualTo(true);
        assertThat(line.getPoints().get(1).isPointFalse()).isEqualTo(true);
    }
}
