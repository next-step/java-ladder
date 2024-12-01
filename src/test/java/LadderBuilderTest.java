
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderBuilderTest {
    private static LadderBuilder ladderBuilder = new LadderBuilder(new RandomGenerator());

    @Test
    void build() {
        Ladder ladder = ladderBuilder.build("pobi,crong,honux".split(","), 5);

        assertThat(ladder.playerCount()).isEqualTo(3);
        assertThat(ladder.height()).isEqualTo(5);
    }

    @Test
    void travel() {
        Ladder ladder = ladderBuilder.build("pobi,crong,honux".split(","), 20);

        int travel_1 = ladder.travel(0);
        int travel_2 = ladder.travel(1);
        int travel_3 = ladder.travel(2);

        System.out.println(travel_1);
        System.out.println(travel_2);
        System.out.println(travel_3);

        assertThat(travel_1).isNotEqualTo(travel_2);
        assertThat(travel_1).isNotEqualTo(travel_3);
    }
}
