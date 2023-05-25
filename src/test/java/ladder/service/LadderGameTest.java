package ladder.service;

import ladder.model.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LadderGameTest {


    private LadderGame ladderGame;

    @BeforeEach
    void setUp() {
        String[] names = {"1","2","3"};
        String[] results = {"1","2","3"};
        int height = 1;
        ladderGame = new LadderGame(names,results,height);

    }

    @Test
    @DisplayName("사람 이름 최대 5글자 이상시 Exception 발생")
    void test_person_name_length_check_with_exception(){
        assertThatThrownBy(
                () ->  new Player(1, "123456"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("사람에 이름을 최대5글자까지 부여할 수 있습니다");
    }


    @Test
    @DisplayName("라인을 생성 한다")
    void test_line_list(){
        ladderGame.makeLine();
    }
}