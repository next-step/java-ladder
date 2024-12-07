import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderBuilderTest {
    private final LadderBuilder ladderBuilder = new LadderBuilder(new RandomGenerator());

    @Test
    void build_with_input_1() {
        Ladder ladder = this.ladderBuilder.build("pobi,crong,honux".split(","),  "a,b,c".split(","), 5);

        assertThat(ladder.height()).isEqualTo(5);
        assertThat(ladder.playerCount()).isEqualTo(3);

    }

    @Test
    void build_with_input() {
        Ladder ladder = this.ladderBuilder.build("pobi,crong,honux".split(","), "a,b,c".split(","),20);

        Pos pos_1 = ladder.move(0);
        Pos pos_2 = ladder.move(1);
        Pos pos_3 = ladder.move(2);

        assertThat(pos_1).isNotEqualTo(pos_2);
        assertThat(pos_1).isNotEqualTo(pos_3);
    }

    @Test
    void build() {
        List<List<Boolean>> rands = new ArrayList<>();

        rands.add(Arrays.asList(true, false, false));
        rands.add(Arrays.asList(true, false, false));

        Ladder ladder = this.ladderBuilder.build("a,b,c,d".split(","), "a,b,c,d".split(","), rands);

        assertThat(ladder.height()).isEqualTo(2);
        assertThat(ladder.playerCount()).isEqualTo(4);
        assertThat(ladder.move(0)).isEqualTo(new Pos(0, 2));
    }
}
