package nextstep.ladder;

import nextstep.ladder.domain.Line;
import nextstep.ladder.strategy.RandomStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
@Nested
@DisplayName("Line 클래스는")
public class LineTest {
    @Test
    public void randomLineTest() {
        List<Boolean> list = new ArrayList<>();
        list.add(true);
        list.add(false);
        list.add(true);
        list.add(false);
        int size = 5;
        Line line2 = Line.of(size, (countOfParticipants) -> list);
        System.out.println(line2.getPoints());
    }
}
