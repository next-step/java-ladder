package ladder;

import org.junit.Test;

public class LineTest {
    @Test(expected = IllegalArgumentException.class)
    public void 포인트_개수_1개이하일때() {
        // given
        LineGenerator lineGenerator = new RandomLineGenerator();
        // when
        Line line = lineGenerator.generate(0);
        // then
    }
}
