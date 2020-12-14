package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LadderMemberTest {

    @DisplayName("참가자이름이 null 이거나 공백이면 exception 을 던진다")
    @ParameterizedTest
    @NullAndEmptySource
    void invalidName(String name){
        assertThatThrownBy( () -> new LadderMember(name))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("참가자이름이 5자를 초과하면 exception 을 던진다")
    @Test
    void invalidName2(){
        assertThatThrownBy( () -> new LadderMember("123456"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
