package nextstep.ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

class LinesTest {

    @Test
    public void create() throws Exception {
        LadderHeight ladderHeight = new LadderHeight(3);
        assertThat(new Lines(ladderHeight, 5).size()).isEqualTo(ladderHeight.getHeight());
    }

    @Test
    public void create_라인_너비_예외() throws Exception {
        LadderHeight ladderHeight = new LadderHeight(3);
        assertThatThrownBy(() -> {
            new Lines(ladderHeight, 1);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void create_사다리_높이_예외() throws Exception {
        List<Line> lines = Arrays.asList();
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Lines(lines);
        }).isInstanceOf(IllegalArgumentException.class);
    }

}
