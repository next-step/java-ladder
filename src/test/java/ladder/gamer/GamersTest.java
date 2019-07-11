package ladder.gamer;

import ladder.domain.gamer.Gamers;
import ladder.domain.gamer.info.Gamer;
import ladder.domain.gamer.message.ErrorMessages;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class GamersTest {
    private Gamers gamers;

    @BeforeEach
    void setUp() {
        //Given
        gamers = Gamers.newInstance();
        gamers.addGamers("one,two,three");
        
    }
    
    @Test
    @DisplayName("[success] 콤마(,) 로 구분된 문자열을 받아 정상적으로 Gamers에 추가한다.")
    void newGamersTest() {
        //Then
        Assertions.assertThat(gamers.getSize()).isEqualTo(3);
    }
    
    @Test
    @DisplayName("[success] Gamers 이름의 목록을 정상적으로 가져온다.")
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
        Gamer gamer = Gamer.from("one");
        
        //When
        int lineNumber = gamers.getLineNumber(gamer);
        
        //Then
        Assertions.assertThat(lineNumber).isEqualTo(0);
    }
    
    @Test
    @DisplayName("[fail] 유저 이름으로 시작 라인 번호를 가져온다. 없는 유저 이름을 입력하였다면 exception 발생")
    void getLineNumberFailTest() {
        //Given
        Gamer gamer = Gamer.from("o");
        
        //Then
        Assertions.assertThatIllegalArgumentException()
            .isThrownBy(() -> gamers.getLineNumber(gamer))
            .withMessage(ErrorMessages.NOT_FIND_GAMER.message());
    }
    
    @Test
    @DisplayName("[success] gamer 가 하나라도 있으면 false")
    void isGamerNamesNeededFalseTest() {
        //Given
        Gamers gamers = Gamers.newInstance();
        gamers.addGamers("a");
        
        //When
        boolean gamerNeeded = gamers.isGamerNamesNeeded();
        
        //Then
        Assertions.assertThat(gamerNeeded).isFalse();
    }
    
    @Test
    @DisplayName("[success] gamer 가 하나도 없으면 true")
    void isGamerNamesNeededTrueTest() {
        //Given
        Gamers gamers = Gamers.newInstance();
        
        //When
        boolean gamerNeeded = gamers.isGamerNamesNeeded();
        
        //Then
        Assertions.assertThat(gamerNeeded).isTrue();
    }
}
