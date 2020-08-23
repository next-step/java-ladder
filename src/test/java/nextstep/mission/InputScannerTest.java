package nextstep.mission;

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
}
