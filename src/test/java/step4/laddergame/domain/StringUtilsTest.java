package step4.laddergame.domain;


import org.junit.jupiter.api.Test;
import step4.laddergame.domain.ladder.LadderLine;
import step4.laddergame.domain.ladder.Size;
import step4.laddergame.util.StringUtils;

import static step4.laddergame.util.StringUtils.fitLine;
import static org.assertj.core.api.Assertions.assertThat;

public class StringUtilsTest {

    private Size size = new Size(5, 6);

    @Test
    void 이름공백조정() {
        String name = "이름";
        String predict = "   이름 ";
        assertThat(StringUtils.fitSpace(name)).isEqualTo(predict);
    }

    @Test
    void 연결안된라인을_문자열로표현() {
        LadderLine noLinkLine = LadderLine.init(size.getWidth(), () -> false);
        String predict = "     |     |     |     |     |     |";
        assertThat(fitLine(noLinkLine)).isEqualTo(predict);
    }

    @Test
    void 연결된라인을_문자열로표현() {
        LadderLine allLinkLine = LadderLine.init(size.getWidth(), () -> true);
        String predict = "     |-----|     |-----|     |-----|";
        assertThat(fitLine(allLinkLine)).isEqualTo(predict);
    }
}
