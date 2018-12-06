package dto;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {

    @Test
    public void 라인초기화테스트() {
        Line lines = new Line(4);
        assertThat(lines.getPoints()).hasSize(4);
    }

    @Test
    public void 라인_디렉션출력_스트() {
        Line lines = new Line(6);
        for(Point point : lines.getPoints()){
            System.out.println(point.getDirection());
        }
    }
}