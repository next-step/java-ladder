package JavaLadder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LineTest {

    @Test
    @DisplayName("라인생성테스트")
    public void lineConstructorTest() {
        Line line = new Line(5);
        assertThat(line.size()).isEqualTo(4);
    }

    @Test
    @DisplayName("값확인")
    public void checkTrueTest() {
        List<Boolean> list = Arrays.asList(true,false,true);
        Line line = new Line(list);
        assertThat(line.isTrue(0)).isEqualTo(true);
    }

    @Test
    @DisplayName("한라인에 true갯수확인")
    public void numberOfLineTest() {
        List<Boolean> list = Arrays.asList(true,false,true);
        Line line = new Line(list);
        assertThat(line.numberOfTrue()).isEqualTo(2);
    }

    @Test
    @DisplayName("가장왼쪽포인트이동")
    public void moveTheMostLeftTest() {
        List<Boolean> list = Arrays.asList(true,false,true);
        Line line = new Line(list);
        Point point = new Point(0);
        line.isMove(point);
        assertThat(point.getPoint()).isEqualTo(1);
    }

    @Test
    @DisplayName("라인상의 중간위치 포인트이동")
    public void moveLeftAndRightTest() {
        List<Boolean> list = Arrays.asList(false,true,false);
        Line line = new Line(list);
        Point point = new Point(1);
        line.isMove(point);
        assertThat(point.getPoint()).isEqualTo(2);
    }

    @Test
    @DisplayName("라인상의 중간위치 포인트이동")
    public void moveTheMostIrhgtTest() {
        List<Boolean> list = Arrays.asList(false,false,true);
        Line line = new Line(list);
        Point point = new Point(3);
        line.isMove(point);
        assertThat(point.getPoint()).isEqualTo(2);
    }
}
