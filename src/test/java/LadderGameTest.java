import Ladder.*;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LadderGameTest {
    Persons persons;
    Results results;
    Line oneLine;

    @Before
    public void setUp() throws Exception {
        persons = new Persons("heel,good,fufu,hhh");
        results = new Results("꽝,1000,2000,꽝");
        oneLine = new Line(4);
    }


/*    @Test
    public void 특정사람_결과출력() throws Exception {
        LadderGame ladderGame = new LadderGame(person); //하나의 결과를 출력?
        assertThat(ladderGame.getResult(person)).isEqualTo(new Result("result"));

    }*/

    @Test
    public void 결과갯수_체크() {
        String results = "5000,꽝,1000";
        Results allResult = new Results(results);
        assertThat(allResult.resultCounts()).isEqualTo(3);
    }
}
