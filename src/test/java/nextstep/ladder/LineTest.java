package nextstep.ladder;

import nextstep.ladder.model.Line;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LineTest {

    @Test
    void 참여자_수에_따른_Point_개수_확인() {
        int countOfPerson = 4;
        Line line = new Line(countOfPerson);
        assertEquals(countOfPerson, line.getPoints().size());
    }

    @Test
    void 참여자가_1명일_때_Point_개수_확인() {
        int countOfPerson = 1;
        Line line = new Line(countOfPerson);
        assertEquals(countOfPerson, line.getPoints().size());
    }

    @Test
    void 참여자_수가_1명_미만일_때_IllegalArgumentException_발생() {
        assertThrows(IllegalArgumentException.class, () -> new Line(0));
    }
}
