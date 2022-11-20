package nextstep.ladder;

import nextstep.ladder.domain.Height;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HeightTest {

    @Test
    void 높이_입력(){
        int height = 5;
        assertThat(new Height(height)).isInstanceOf(Height.class);
    }
}
