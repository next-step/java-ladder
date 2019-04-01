package laddergame.domain;

import laddergame.service.LadderRandomValueGenerator;
import laddergame.service.LadderValueGenerator;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static org.assertj.core.api.Assertions.assertThat;

public class LadderLineTest extends BaseDomainTest {

    private static LadderValueGenerator falseGenerator = () -> false;
    private static LadderValueGenerator trueGenerator = () -> true;

    @Test
    public void init() {
        int sizeOfPerson = 5;
        System.out.println(LadderLine.init(sizeOfPerson, LadderRandomValueGenerator.getInstance()));
    }

    @Test
    public void init_for_two_points_false() {
        LadderLine expected = getLadderLine(Arrays.asList(FALSE));
        LadderLine actual = LadderLine.init(2, falseGenerator);

        assertThat(expected).isEqualTo(actual);
    }

    @Test
    public void init_for_two_points_true() {
        LadderLine expected = getLadderLine(Arrays.asList(TRUE));
        LadderLine actual = LadderLine.init(2, trueGenerator);

        assertThat(expected).isEqualTo(actual);
    }

    @Test
    public void init_for_three_points_false_false() {
        LadderLine expected = getLadderLine(Arrays.asList(FALSE, FALSE));
        LadderLine actual = LadderLine.init(3, falseGenerator);

        assertThat(expected).isEqualTo(actual);
    }

    @Test
    public void init_for_three_points_false_true() {
        LadderLine expected = getLadderLine(Arrays.asList(FALSE, TRUE));

        List<Point> actualPoints = new ArrayList<>();
        Point curPoint = LadderLine.initFirst(actualPoints, falseGenerator);
        curPoint = LadderLine.initBody(3, actualPoints, curPoint, trueGenerator);
        LadderLine.initLast(actualPoints, curPoint);

        assertThat(expected).isEqualTo(new LadderLine(actualPoints));
    }

    @Test
    public void init_for_three_points_true_false() {
        LadderLine expected = getLadderLine(Arrays.asList(TRUE, FALSE));

        List<Point> actualPoints = new ArrayList<>();
        Point curPoint = LadderLine.initFirst(actualPoints, trueGenerator);
        curPoint = LadderLine.initBody(3, actualPoints, curPoint, falseGenerator);
        LadderLine.initLast(actualPoints, curPoint);

        assertThat(expected).isEqualTo(new LadderLine(actualPoints));
    }

    @Test
    public void init_for_four_points_false_false_false() {
        LadderLine expected = getLadderLine(Arrays.asList(FALSE, FALSE, FALSE));
        LadderLine actual = LadderLine.init(4, falseGenerator);

        assertThat(expected).isEqualTo( actual);
    }

    @Test
    public void init_for_four_points_true_false_false() {
        LadderLine expected = getLadderLine(Arrays.asList(TRUE, FALSE, FALSE));

        List<Point> actualPoints = new ArrayList<>();
        Point curPoint = LadderLine.initFirst(actualPoints, trueGenerator);
        curPoint = LadderLine.initBody(4, actualPoints, curPoint, falseGenerator);
        LadderLine.initLast(actualPoints, curPoint);

        assertThat(expected).isEqualTo(new LadderLine(actualPoints));
    }

    @Test
    public void init_for_four_points_true_false_true() {
        LadderLine expected = getLadderLine(Arrays.asList(TRUE, FALSE, TRUE));

        List<Point> actualPoints = new ArrayList<>();
        Point curPoint = LadderLine.initFirst(actualPoints, trueGenerator);
        curPoint = LadderLine.initBody(3, actualPoints, curPoint, falseGenerator);
        LadderLine.initBody(4, actualPoints, curPoint, trueGenerator);

        assertThat(expected).isEqualTo(new LadderLine(actualPoints));
    }

    @Test
    public void init_for_four_points_false_true_false() {
        LadderLine expected = getLadderLine(Arrays.asList(FALSE, TRUE, FALSE));

        List<Point> actualPoints = new ArrayList<>();
        Point curPoint = LadderLine.initFirst(actualPoints, falseGenerator);
        curPoint = LadderLine.initBody(3, actualPoints, curPoint, trueGenerator);
        LadderLine.initBody(4, actualPoints, curPoint, falseGenerator);

        assertThat(expected).isEqualTo(new LadderLine(actualPoints));
    }

    @Test
    public void move() {
        LadderLine line = LadderLine.init(2, LadderRandomValueGenerator.getInstance());
        System.out.println("ladder result : " + line.move(0));
    }
}