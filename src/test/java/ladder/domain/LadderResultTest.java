package ladder.domain;

import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.assertThat;

public class LadderResultTest {

    @Test
    void result() {
        Players players = new Players("user1, user2, user3");
        Ladder ladder = new Ladder(3, 5, new SequentialConnectionStratrgy());

        Players result = LadderResult.result(players,ladder);
        assertThat(result).isNotNull();
    }
}
