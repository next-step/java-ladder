package ladderGame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {

    @Test
    @DisplayName("사다리 생성")
    public void create() {

        List<Layer> layers = Arrays.asList(
                Layer.of(Arrays.asList(true, false, true)),
                Layer.of(Arrays.asList(false, false, true)),
                Layer.of(Arrays.asList(false, false, true)),
                Layer.of(Arrays.asList(true, false, true))
        );
        Ladder ladder = Ladder.of(layers);
        assertThat(ladder.size()).isEqualTo(4);

    }
}