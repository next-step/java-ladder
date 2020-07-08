package domain;

import generator.FalsePointGenerator;
import generator.RandomPointGenerator;
import generator.TruePointGenerator;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class LineTest {

    @Test
    public void 라인의_포인트는_사람수와_같다() {
        int personSize = 3;
        Line line = Line.of(personSize);

        assertThat(line.getPersonSize()).isEqualTo(personSize);
    }

    @Test
    void falseGenerator() {
        Direction next = Direction.of(false, true).next(new FalsePointGenerator());

        assertEquals(next, Direction.of(true, false));
    }

    @Test
    public void 이전_포인트가_연결이면_다음은_연결되지않는다() {
        boolean result = new RandomPointGenerator().next(true);

        assertFalse(result);
    }

    @Test
    void 앞뒤_point가_false면_인덱스는_그대로다() {
        // |     |     |
        Line line = Line.of(3, new FalsePointGenerator());
        int nextPointIndex = line.nextPointIndex(1);

        assertEquals(nextPointIndex, 1);
    }

    @Test
    void 왼쪽으로_연결되면_인덱스가_줄어든다() {
        // |-----|     |
        Line line = Line.of(3, new TruePointGenerator());
        int nextPointIndex = line.nextPointIndex(1);

        assertEquals(nextPointIndex, 0);
    }

    @Test
    void 오른쪽으로_연결되면_인덱스가_커진다() {
        // |-----|     |-----|
        Line line = Line.of(4, new TruePointGenerator());
        int nextPointIndex = line.nextPointIndex(2);

        assertEquals(nextPointIndex, 3);
    }
}