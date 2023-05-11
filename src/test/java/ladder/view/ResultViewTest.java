package ladder.view;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class ResultViewTest {

    @Test
    @DisplayName(" Boolean이 true이면 '-' 출력")
    void when_value_equal_true_print_dash(){
        assertThat(ResultView.getPoint(true)).isEqualTo("-");
    }

    @ParameterizedTest
    @CsvSource(value = {"true:-", "false:' '"},delimiter = ':')
    void test_get_point_method(Boolean value, String point){
        assertThat(ResultView.getPoint(value)).isEqualTo(point);
    }

    @Test
    @DisplayName("player 출력 테스트 case1")
    void test_players_name_case1(){
        String[] players = {"pobi","honux","crong","jk"};
        ResultView.showPlayers(players);
    }

    @Test
    @DisplayName("player 출력 테스트 case2")
    void test_players_name_case2(){
        String[] players = {"apobi","ux","crong","jk"};
        ResultView.showPlayers(players);
    }
}
