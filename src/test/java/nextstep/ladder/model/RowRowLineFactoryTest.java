package nextstep.ladder.model;

import static org.assertj.core.api.Assertions.assertThat;

import nextstep.ladder.model.RowLine;
import nextstep.ladder.model.RowLineFactory;
import nextstep.ladder.model.RandomLineGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RowRowLineFactoryTest {

    @DisplayName("참여자 수를 받아서 라인 하나를 만든다.")
    @Test
    void createOneLine(){
        RowLine rowLine = RowLineFactory.from(RandomLineGenerator.getInstance(), 4).line();
        assertThat(rowLine.lineSize()).isEqualTo(4);
    }

}
