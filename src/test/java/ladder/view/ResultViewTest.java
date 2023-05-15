package ladder.view;


import ladder.model.Players;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ResultViewTest {


    @Test
    @DisplayName("player 출력 테스트 case1")
    void test_players_name_case1(){
        String[] names = {"pobi"};
        Players players= new Players(names);
        ResultView.showPlayers(players);
    }

    @Test
    @DisplayName("player 출력 테스트 case2")
    void test_players_name_case2(){
        String[] names = {"pobi", "1234"};
        Players players= new Players(names);
        ResultView.showPlayers(players);
    }
}
