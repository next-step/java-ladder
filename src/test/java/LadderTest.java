import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LadderTest {

    @Test
    public void 사람수_구하기() throws Exception {
        String persons="heel,good,fufu,hhh";
        Person personObject = new Person(persons);
        int result = personObject.getCount();
        assertThat(result).isEqualTo(4);
    }

    @Test(expected=Exception.class)
    public void 사람이름_길이체크() throws Exception {
        String persons = "hwanseok,good,hhlleoe";
        Person personObject = new Person(persons);
    }
    @Test
    public void 첫번째_포인트_체크() {

        Line line = new Line(4);
    }

    @Test
    public void 앞좌표상태_체크() {
        Line line = new Line(3);
        List<Point> points = new ArrayList<>();
        points.add(Point.of(true));
        boolean result = line.validationCheck(points);
        assertThat(result).isEqualTo(true);


    }

}
