package nextstep.ladder;

import nextstep.ladder.model.Line;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LineTest {



    @Test
    @DisplayName("Line 생성 테스트")
    public void lineMakeTest(){
        Line line = new Line(7);
        System.out.println(line.getPoints().toString());

    }
}
