package ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class PlayersTest {
    @Test
    @DisplayName("참가자 중에 가장 이름이 긴 값을 가져온다")
    public void name_length_max(){
        Assertions.assertThat(Players.of(List.of("a", "abc", "abcde")).nameLengthMax()).isEqualTo(5);
    }
}
