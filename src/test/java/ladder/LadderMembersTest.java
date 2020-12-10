package ladder;

import ladder.domain.LadderMembers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LadderMembersTest {

    @DisplayName("참가자가 1명 이하면 exception 을 던진다")
    @Test
    void members(){
        assertThatThrownBy( () -> new LadderMembers(Arrays.asList("nio")))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("참가자이름이 5자를 넘어서면 exception 을 던진다")
    @Test
    void longMemberName(){
        assertThatThrownBy( () -> new LadderMembers(Arrays.asList("longname", "hoon")))
                .isInstanceOf(IllegalArgumentException.class);
    }


}