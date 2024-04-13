package ladder.domain.result;

import ladder.domain.participants.Name;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class GameRecordsTest {

    public static final GameRecords gameRecords = new GameRecords(
            List.of(
                    RewardResultTest.result1, RewardResultTest.result2, RewardResultTest.result3)
    );

    @Test
    void find_record_by_name() {
        String pobi1 = "pobi";
        Name pobi = new Name(pobi1);

        assertThat(gameRecords.find(pobi))
                .isEqualTo(new GameRecords(List.of(RewardResultTest.result1)));
    }
}