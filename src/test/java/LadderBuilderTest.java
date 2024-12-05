
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderBuilderTest {
    private static LadderBuilder ladderBuilder = new LadderBuilder(new RandomGenerator());

    @Test
    void build() {
        Ladder ladder = ladderBuilder.build("pobi,crong,honux".split(","),  "a,b,c".split(","), 5);

        assertThat(ladder.height()).isEqualTo(5);
    }

    @Test
    void travel() {
        Ladder ladder = ladderBuilder.build("pobi,crong,honux".split(","), "a,b,c".split(","),20);

        TravelResult travel_1 = ladder.travel(0);
        TravelResult travel_2 = ladder.travel(1);
        TravelResult travel_3 = ladder.travel(2);

        assertThat(travel_1).isNotEqualTo(travel_2);
        assertThat(travel_1).isNotEqualTo(travel_3);
    }
}
