package nextstep.ladder.domain.line;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class LineTest {

    @Test
    public void 한_라인은_사람의_수보다_하나_작게_생성되어야_한다() {
        int countOfPerson = 6;
        Line line = new Line(countOfPerson);

        assertThat(line.size()).isEqualTo(countOfPerson - 1);
    }
}
