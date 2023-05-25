package nextstep.ladder;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class LadderTest {
    @Test
    public void levelAndUsersAreSet() {
        var levels = 5;
        var users = new Users(List.of("erik", "jake", "david"));

        var ladder = new Ladder(users, levels);

        assertThat(ladder.levels).isEqualTo(levels);
        assertThat(ladder.users).containsExactly("erik", "jake", "david");
    }
}
