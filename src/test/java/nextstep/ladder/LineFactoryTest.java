package nextstep.ladder;

import static org.assertj.core.api.Assertions.assertThat;

import nextstep.ladder.model.Line;
import nextstep.ladder.model.LineFactory;
import nextstep.ladder.model.RandomLineGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LineFactoryTest {

    @DisplayName("참여자 수를 받아서 라인 하나를 만든다.")
    @Test
    void createOneLine(){
        Line line = LineFactory.from(RandomLineGenerator.getInstance(), 4).line();
        assertThat(line.lineSize()).isEqualTo(4);
    }

}
