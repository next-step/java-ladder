package ladder;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class LadderGameTest {

    @Test
    void of() {
        // given
        final String usersExpression = "pobi,honux,crong,jk";
        final int ladderHeight = 5;

        // when 
        final LadderGame result = LadderGame.of(usersExpression, ladderHeight);

        // then
        assertThat(result).isNotNull();
    }
}
