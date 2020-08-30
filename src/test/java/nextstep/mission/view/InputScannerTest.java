package nextstep.mission.view;

import nextstep.mission.domain.Participants;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class InputScannerTest {

    @Test
    void getUsers() {
        Participants users = InputScanner.getUsers("user1,user2,user3,user4");

        assertThat(users.size()).isEqualTo(4);
        assertThat(users.contains("user1")).isTrue();
        assertThat(users.contains("user2")).isTrue();
        assertThat(users.contains("user3")).isTrue();
        assertThat(users.contains("user4")).isTrue();
    }

    @Test
    void getResults() {
        List<String> results = InputScanner.getResults("꽝,5000,꽝,3000");

        assertThat(results).hasSize(4);
        assertThat(results).containsExactly(
                "꽝",
                "5000",
                "꽝",
                "3000"
        );
    }
}
