import Ladder.*;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LadderGameTest {
    Persons persons;
    Results results;
    Line oneLine;
    private static final int BEGIN_POINT =0;
    private static final int MIDDLE_POINT =1;
    private static final int LAST_POINT =3;


    @Before
    public void setUp() throws Exception {
        persons = new Persons("heel,good,fufu,hhh");
        results = new Results("꽝,1000,2000,꽝");
        oneLine = new Line(4);
        oneLine.setPoints(asList(Point.of(true), Point.of(false), Point.of(true)));

    }

    @Test
    public void 결과갯수_체크() {
        String results = "5000,꽝,1000";
        Results allResult = new Results(results);
        assertThat(allResult.resultCounts()).isEqualTo(3);
    }
    @Test
    public void 맨처음_위치에서_이동(){

        assertThat(oneLine.decideDestination(BEGIN_POINT)).isEqualTo(1);

    }
    @Test
    public void 중간_위치에서_이동(){
        assertThat(oneLine.decideDestination(MIDDLE_POINT)).isEqualTo(0);

    }
    @Test
    public void 마지막_위치에서_이동(){
        assertThat(oneLine.decideDestination(LAST_POINT)).isEqualTo(2);

    }
}
