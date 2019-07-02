package ladder.user;

import ladder.domain.gamer.Gamers;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

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
    
    @Test
    @DisplayName("[success] 생성시 입력된 이름의 목록을 정상적으로 가져온다.")
    void getGamerNamesTest() {
        //Given
        List<String> givenGamerNames = Arrays.asList("aa", "bb", "cc");
        Gamers gamers = Gamers.of("aa,bb,cc");
        
        //When
        List<String> resultGamerNames = gamers.getGamerNames();
        
        //Then
        Assertions.assertThat(givenGamerNames.containsAll(resultGamerNames)).isTrue();
    }
}
