package laddergame.domain;

import laddergame.domain.ladder.line.Line;
import laddergame.domain.ladder.Size;
import laddergame.util.StringUtils;
import org.junit.jupiter.api.Test;

import static laddergame.util.StringUtils.fitLine;
import static org.assertj.core.api.Assertions.assertThat;

public class StringUtilsTest {

    private Size size = new Size(5, 6);

    @Test
    void 이름공백조정() {
        String name = "이름";
        String predict = "   이름 ";

        assertThat(StringUtils.fitName(name)).isEqualTo(predict);
    }

    @Test
    void 연결안된라인을_문자열로표현() {
        Line noLinkLine = new Line(size);
        String predict = "     |     |     |     |     |     |";


        assertThat(fitLine(noLinkLine)).isEqualTo(predict);
    }

    @Test
    void 연결된라인을_문자열로표현() {
        Line allLinkLine = new Line(size);
        allLinkLine.connect(() -> true);
        String predict = "     |-----|     |-----|     |-----|";


        assertThat(fitLine(allLinkLine)).isEqualTo(predict);
    }



}
