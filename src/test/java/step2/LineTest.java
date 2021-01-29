package step2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LineTest {

    // given
    int countOfPerson = 0;

    // when
    Line line = null;

    @BeforeEach
    public void setUp() {
        // given
        countOfPerson = 4;

        // when
        line = Line.newLine(countOfPerson);
    }

    @Test
    void 라인_생성_개수() {
        // then
        assertThat(line.size()).isEqualTo(countOfPerson - 1);
    }

    @Test
    void 중복_라인_필터() {
        // then
        assertThat(line.getPoints().get(0)).isNotEqualTo(line.getPoints().get(1));
    }
}