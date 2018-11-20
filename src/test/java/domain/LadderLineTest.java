package domain;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static org.assertj.core.api.Assertions.assertThat;

public class LadderLineTest {
    @Test
    public void init() {
        int sizeOfPerson = 5;
        System.out.println(LadderLine.init(sizeOfPerson));
    }

    @Test
    public void move() {
        LadderLine line = LadderLine.init(2);
        System.out.println("ladder result : " + line.move(0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void 음수init() {
        int sizeOfPerson = -5;
        System.out.println(LadderLine.init(sizeOfPerson));
    }


    @Test
    public void 사다리그리기() {
        List<Point> points = new ArrayList<>();
        Point first = Point.first(FALSE);
        Point second = first.next(TRUE);
        Point third = second.next(FALSE);
        points.add(first);
        points.add(second);
        points.add(third);
        LadderLine ladderLine = LadderLine.ofList(points);


        String str = ladderLine.toString();
        assertThat(str).isEqualTo("|     |-----|     |");
    }


}