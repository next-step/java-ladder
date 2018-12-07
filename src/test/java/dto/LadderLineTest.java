package dto;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class LadderLineTest {

    @Test
    public void 라인초기화테스트() {
        LadderLine lines = new LadderLine(4,Difficulty.NORMAL);
        assertThat(lines.getPoints()).hasSize(4);
    }

    @Test
    public void 라인_디렉션출력_스트() {
        LadderLine lines = new LadderLine(6,Difficulty.NORMAL);
        for(Point point : lines.getPoints()){
            System.out.println(point.getDirection());
        }
    }

    @Test
    public void 이동테스트() {
        LadderLine line = new LadderLine(5,Difficulty.NORMAL);
        System.out.println("ladder result : " + line.move(0));
    }
}