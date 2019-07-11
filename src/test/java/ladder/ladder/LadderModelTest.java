package ladder.ladder;

import ladder.domain.gamer.Gamers;
import ladder.domain.gamer.message.ErrorMessages;
import ladder.domain.ladder.LadderModel;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderModelTest {
    private LadderModel ladderModel;
    private Gamers gamers;
    
    @BeforeEach
    void setUp() {
        ladderModel = LadderModel.newInstance();
        gamers = Gamers.newInstance();
    }
    
    @Test
    @DisplayName("[success] 파라미터로 입력된 숫자만큼의 Line 를 생성한다.")
    void makeRowsTest() {
        //Given
        int cellSize = 5;
        gamers.addGamers("a,b,c,d,e");
        
        //When
        ladderModel.makeLadder(cellSize, gamers);
        
        //Then
        Assertions.assertThat(ladderModel.getSize()).isEqualTo(gamers.getSize());
    }
    
    @Test
    @DisplayName("[fail] 입력된 라인번호로 보상정보를 가져온다. 입력된 라인번호가 총 라인수를 넘어가면 exception 발생")
    void test() {
        //Given
        gamers.addGamers("a,b,c");
        ladderModel.makeLadder(3, gamers);
        
        //Then
        Assertions.assertThatIllegalArgumentException()
            .isThrownBy(() -> ladderModel.getGoalNumber(4))
            .withMessage(ErrorMessages.OVER_INPUT_LADDER_SIZE.message());
    }
    
    @Test
    @DisplayName("[success] 사다리가 생성되지 않았다면 true")
    void isLadderSizeTrueTest() {
        //Given
        //When
        boolean ladderSizeNeeded = ladderModel.isLadderSizeNeeded();
        boolean ladderMade = ladderModel.isLadderMade();
        
        //Then
        Assertions.assertThat(ladderSizeNeeded).isTrue();
        Assertions.assertThat(ladderMade).isFalse();
    }
    
    @Test
    @DisplayName("[success] 사다리가 이미 생성되었다면 false")
    void isLadderSizeFalseTest() {
        //Given
        Gamers gamers = Gamers.newInstance();
        gamers.addGamers("a,b,c");
        ladderModel.makeLadder(3, gamers);
        
        //When
        boolean ladderSizeNeeded = ladderModel.isLadderSizeNeeded();
        boolean ladderMade = ladderModel.isLadderMade();
        
        //Then
        Assertions.assertThat(ladderSizeNeeded).isFalse();
        Assertions.assertThat(ladderMade).isTrue();
    }
}
