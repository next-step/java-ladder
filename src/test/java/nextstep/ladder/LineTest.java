package nextstep.ladder;

import static org.assertj.core.api.Assertions.assertThat;

import nextstep.ladder.model.Line;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LineTest {

    @DisplayName("참여자 수를 받아서 라인 하나를 만든다.")
    @Test
    void createOneLine(){
        Line line = Line.from(4);
        assertThat(line.lineSize()).isEqualTo(4);
    }

}
