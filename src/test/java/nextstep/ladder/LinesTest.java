package nextstep.ladder;

import nextstep.ladder.model.Lines;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LinesTest {

    @Test
    @DisplayName("Lines 생성 테스트")
    public void LinesTest(){
        Lines lines = new Lines(5,4);

        assertThat(lines.getLines().size()).isEqualTo(4);
    }

}
