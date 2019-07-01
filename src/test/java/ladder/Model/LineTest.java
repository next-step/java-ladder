package ladder.Model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {

    @Test
    @DisplayName("사다리 생성에 사용될 가로 라인 생성 테스트")
    void createLine(){
        boolean beforLine = false;
        Line lines = new Line(5);
        List<Boolean> linePoints = lines.getPoints();
        for(boolean line : linePoints){
            if(beforLine){
                assertThat(beforLine).isNotEqualTo(line);
            }
            beforLine = line;
        }
    }

}
