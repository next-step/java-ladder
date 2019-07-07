package ladder.gamer;

import ladder.domain.gamer.Gamers;
import ladder.domain.gamer.message.ErrorMessages;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class GamersTest {
    private Gamers gamers;

    @BeforeEach
    void setUp() {
        //Given
        gamers = Gamers.from("one,two,three");
        
    }
    
    @Test
    @DisplayName("[success] 콤마(,) 로 구분된 문자열을 받아 정상적으로 Gamers를 생성한다.")
    void newGamersTest() {
        //Then
        Assertions.assertThat(gamers.getSize()).isEqualTo(3);
    }
    
    @Test
    @DisplayName("[success] 생성시 입력된 이름의 목록을 정상적으로 가져온다.")
    void getGamerNamesTest() {
        //Given
        List<String> givenGamerNames = Arrays.asList("one", "two", "three");

        //When
        List<String> resultGamerNames = gamers.getGamerNames();
        
        //Then
        Assertions.assertThat(givenGamerNames.containsAll(resultGamerNames)).isTrue();
    }
    
    @Test
    @DisplayName("[success] 유저 이름으로 시작 라인 번호를 가져온다.")
    void getLineNumberTest() {
        //Given
        String gamerName = "one";
        
        //When
        int lineNumber = gamers.getLineNumber("one");
        
        //Then
        Assertions.assertThat(lineNumber).isEqualTo(0);
    }
    
    @Test
    @DisplayName("[fail] 유저 이름으로 시작 라인 번호를 가져온다. 없는 유저 이름을 입력하였다면 exception 발생")
    void getLineNumberFailTest() {
        //Given
        String gamerName = "o";
        
        //Then
        Assertions.assertThatIllegalArgumentException()
            .isThrownBy(() -> gamers.getLineNumber(gamerName))
            .withMessage(ErrorMessages.NOT_FIND_GAMER.message());
    }
}
