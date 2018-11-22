import Ladder.Line;
import Ladder.Persons;
import Ladder.Point;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LadderTest {
    String persons="";
    @Before
    public void setup(){
        persons="heel,good,fufu,hhh";
    }

    @Test
    public void 사람수_구하기() throws Exception {
        persons="heel,good,fufu,hhh";
        Persons personsObject = new Persons(persons);
        int result = personsObject.personCount();
        assertThat(result).isEqualTo(4);
    }

    @Test(expected=Exception.class)
    public void 사람이름_길이체크() throws Exception {
        persons = "hwanseok,good,hhlleoe";
        Persons personsObject = new Persons(persons);
    }

    @Test
    public void 앞좌표상태_체크() {
        Line line = new Line(3);
        List<Point> points = new ArrayList<>();
        //points.add(Point.of(true));
        points.add(new Point(true));
        boolean result = line.validationCheck(points);
        assertThat(result).isEqualTo(true);


    }

}
