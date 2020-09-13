package nextstep.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LineTest {

    @Test
    @DisplayName("line 생성 테스트")
    public void test(){
        Line line = new Line(5);

        String lineStr = line.toString();

       assertThat(lineStr.split("\\|").length).isEqualTo(5);
    }
}