package ladder.domain.result;

import ladder.domain.participants.Gamer;
import ladder.domain.participants.Name;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RecordsTest {

    @Test
    void find_record_by_name() {
        String pobi1 = "pobi";
        Name pobi = new Name(pobi1);
        RewardResult result1 = new RewardResult(new Reward("item0", 0), new Gamer(pobi1, 0));
        RewardResult result2 = new RewardResult(new Reward("item1", 0), new Gamer("honux", 1));
        RewardResult result3 = new RewardResult(new Reward("item2", 0), new Gamer("crong", 2));
        Records records = new Records(List.of(result1, result2, result3));

        assertThat(records.find(pobi))
                .isEqualTo(new Records(List.of(result1)));
    }
}