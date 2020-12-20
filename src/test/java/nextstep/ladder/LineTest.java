package nextstep.ladder;

import nextstep.ladder.model.Line;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {



    @Test
    @DisplayName("Line 생성 테스트")
    public void lineMakeTest(){
        Line line = new Line(7);
        System.out.println(line.getPoints().toString());

    }

    @Test
    @DisplayName("PreLine 테스트")
    public void preLineTest(){

        Line line = new Line(5);
        List<Boolean> points = line.getPoints();
        int index = points.indexOf(true);

        if(index !=-1){
            assertThat(line.isPreLine(index+1)).isEqualTo(false);
        }


    }

}
