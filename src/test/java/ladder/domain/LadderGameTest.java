package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LadderGameTest {

    @DisplayName("참가자가 1명 이하면 exception 을 던진다")
    @Test
    void members(){
        assertThatThrownBy( () -> new LadderGame("nio", "1000", 5))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("참가자이름이 5자를 넘어서면 exception 을 던진다")
    @Test
    void longMemberName(){
        assertThatThrownBy( () -> new LadderGame("longname,hoon", "0,1000", 5))
                .isInstanceOf(IllegalArgumentException.class);
    }

}