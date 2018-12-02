import domain.Line;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {

    @Test
    public void 라인그릴까말까() {
        ArrayList<Boolean> lines = new ArrayList<>();
        Boolean yesOrYes = false;
        lines.add(yesOrYes);
        int thisWillbeRandomVal = 6;
        lines.add(false);
        if(thisWillbeRandomVal > 5) {
            if(lines.get(0).equals(false)) {
                lines.set(1, true);
            }
        }
        assertThat(lines).isEqualTo(Arrays.asList(false, true));
    }

    @Test(expected = IllegalArgumentException.class)
    public void 예외처리() {
        String str = "pobi,honux,crong,jk,exception";
        String arr[] = str.split(",");
        Arrays.stream(arr).forEach(s -> {
            if(s.length() > 5 ) {
                throw new IllegalArgumentException();
            }
        });
    }

    @Test
    public void 왼쪽으로가기() {
        int countOfPerson = 4;
        Line line = Line.from(countOfPerson);
        int checkPoint = 2;
        int checkElement = 2;
        line.moveLeft(checkPoint, checkElement);
        if(line.canMove(checkPoint)) {
            assertThat(line.getResultBox().get(checkPoint)).isEqualTo(1);
        }
        if(!line.canMove(checkPoint)) {
            assertThat(line.getResultBox().get(checkPoint)).isEqualTo(2);
        }
    }

    @Test
    public void 오른쪽으로가기() {
        int countOfPerson = 4;
        Line line = Line.from(countOfPerson);
        int checkPoint = 2;
        int checkElement = 2;
        line.moveRight(checkPoint, checkElement);
        if(line.canMove(checkPoint)) {
            assertThat(line.getResultBox().get(checkPoint)).isEqualTo(3);
        }
        if(!line.canMove(checkPoint)) {
            assertThat(line.getResultBox().get(checkPoint)).isEqualTo(2);
        }
    }
}
