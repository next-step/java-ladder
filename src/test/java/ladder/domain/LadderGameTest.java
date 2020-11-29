package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class LadderGameTest {

    @DisplayName("정적 팩터리 메서드를 이용한 생성")
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
