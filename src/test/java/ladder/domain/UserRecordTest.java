package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;

class UserRecordTest {

    @Test
    @DisplayName("유저의 위치를 기록한다.")
    void recordPoint() {
        Line line = new Line(() -> true, 2);

        UserRecord userRecord = new UserRecord("a", 0);
        userRecord.recordPoints(Collections.singletonList(line));

        assertThat(userRecord.getPoints()).hasSize(2);
        assertThat(userRecord.getPoints()).containsExactly(0, 1);
    }

    @Test
    @DisplayName("유저의 결과를 기록한다.")
    void recordOutcome() {
        Line line = new Line(() -> true, 2);

        UserRecord userRecord = new UserRecord("a", 0);
        userRecord.recordPoints(Collections.singletonList(line));
        userRecord.addOutcome(Arrays.asList("꽝", "당첨"));

        assertThat(userRecord.getOutcome()).isEqualTo("당첨");
    }
}
