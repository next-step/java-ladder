package nextstep.ladder;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class UsersInputTest {
    @Test
    public void parseCommaSplicedUserInput() {
        var input = "pobi, honux, crong, jk";

        var userInput = new UsersInput(input);

        assertThat(userInput.toUsers()).containsExactly("pobi", "honux", "crong", "jk");
    }
}
