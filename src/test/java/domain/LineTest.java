package domain;

import generator.RandomPointGenerator;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertFalse;

public class LineTest {

    @Test
    public void 사람수를_입력받아_라인을_만든다() {
        int personSize = 3;
        Line line = new Line(personSize);

        assertThat(line.getPersonSize()).isEqualTo(personSize);
    }

    @Test
    public void 이전_포인트가_연결이면_다음은_연결되지않는다() {
        boolean result = new RandomPointGenerator().isConnect(true);

        assertFalse(result);
    }
}