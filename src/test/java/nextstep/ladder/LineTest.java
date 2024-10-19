package nextstep.ladder;

import nextstep.ladder.model.Line;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class LineTest {
    @Test
    @DisplayName("line 생성")
    void createLineTest(){
        //given
        Line line = new Line(4, new MockLineGenerator());

        //when
        List<Boolean> points = line.getPoints();

        //then
        Assertions.assertThat(points).hasSize(3);
        for(int i=0; i<points.size(); i++){
            if(i > 0 && points.get(i-1)){
                Assertions.assertThat(points.get(i)).isEqualTo(false);
            }
        }
        System.out.println(points);
    }
}
