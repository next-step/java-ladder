package ladder.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LadderGameTest {


    private LadderGame ladderGame;

    @BeforeEach
    void setUp() {
        ladderGame = new LadderGame();

    }

    @Test
    @DisplayName("사람 이름 최대 5글자 이상시 Exception 발생")
    void test_person_name_length_check_with_exception(){
        assertThatThrownBy(
                () ->  ladderGame.setPlayer("crong123"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("사람에 이름을 최대5글자까지 부여할 수 있습니다");
    }


    @Test
    @DisplayName("사람 이름 다중 입력 테스트")
    void test_person_name_multiple_to_array(){
        ladderGame.setPlayer("crong, honox, pobi");
        assertThat(ladderGame.getPlayers())
                .contains("crong")
                .contains("honox")
                .contains("pobi");
    }


    @Test
    @DisplayName("사다리 높이 입력 테스트")
    void test_ladder_value(){
        ladderGame.setHeight("5");
        assertThat(ladderGame.getHeight()).isEqualTo(5);
    }

    @Test
    @DisplayName("라인을 생성 한다")
    void test_line_list(){
        ladderGame.makeLine();
    }
}