package ladder.user;

import ladder.domain.content.user.Gamers;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GamersTest {
    @Test
    @DisplayName("[success] 콤마(,) 로 구분된 문자열을 받아 정상적으로 Gamers를 생성한다.")
    void newGamersTest() {
        //Given
        String names = "one,two,three";
        
        //When
        Gamers gamers = Gamers.of(names);
        
        //Then
        Assertions.assertThat(gamers.getSize()).isEqualTo(3);
    }
}
