package model;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {

    private Line line;
    private int countOfPerson;

    @Before
    public void setUp() throws Exception {
        countOfPerson = 4;
        line = Line.of(countOfPerson);

    }

    // TODO
    /*
    라인 만들기
    라인 n개 만들기
    높이 입력하기
    사다리 그리기
    라인의 좌표 값에 선이 있는지 유무를 판단하는 로직
    이동하기
     */

    @Test
    public void hasPoint_선있을때(){
        line.addPoint(true);
        line.addPoint(true);
        assertThat(line.hasPoint(1)).isTrue();
    }

    @Test
    public void hasPoint_선없을때(){
        line.addPoint(true);
        line.addPoint(false);
        assertThat(line.hasPoint(1)).isFalse();
    }

    @Test ( expected = IllegalStateException.class)
    public void addPoint_최대높이초과() {
        for (int i = 0; i < countOfPerson +1; i++) {
            line.addPoint(true);
        }
    }


}
