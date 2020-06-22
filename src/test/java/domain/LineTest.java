package domain;

import generator.FalsePointGenerator;
import generator.RandomPointGenerator;
import org.junit.jupiter.api.Test;
import view.OutputView;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class LineTest {

    @Test
    public void 라인의_포인트는_사람수보다_하나작다() {
        int personSize = 3;
        Line line = Line.of(personSize);

        assertThat(line.getPersonSize()).isEqualTo(personSize-1);
    }

    @Test
    void falseGenerator() {
        int personSize = 3;
        Line line = Line.of(personSize, new FalsePointGenerator());

        assertEquals(line.getPoints(), Arrays.asList(false, false));
    }

    @Test
    public void 이전_포인트가_연결이면_다음은_연결되지않는다() {
        boolean result = new RandomPointGenerator().isConnect(true);

        assertFalse(result);
    }
}