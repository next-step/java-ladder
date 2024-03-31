package nextstep.ladder.domain.line;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class LinesTest {

    @Test
    public void 높이와_사람의_수가_전달될때_높이와_사람의_수만큼_라인들이_생겨야_한다 (){
        int height = 5;
        int countOfPerson = 4;
        Lines lines = new Lines(height, countOfPerson);

        assertThat(lines.size()).isEqualTo(5);
    }
}
