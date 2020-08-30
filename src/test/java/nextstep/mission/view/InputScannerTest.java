package nextstep.mission.view;

import nextstep.mission.domain.Participant;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class InputScannerTest {

    @Test
    void getUsers() {
        List<Participant> users = InputScanner.getUsers("user1,user2,user3,user4");

        assertThat(users).hasSize(4);
        assertThat(users).containsExactly(
                new Participant("user1"),
                new Participant("user2"),
                new Participant("user3"),
                new Participant("user4")
        );
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
