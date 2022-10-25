package laddergame.view;

import laddergame.domain.People;
import laddergame.domain.Rewards;
import laddergame.domain.service.LadderGame;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OutputViewTest {

    @Test
    @DisplayName("프린트 확인")
    void print() {
        //given
        String[] names = "pobi,honux,crong,jk".split(",");
        Rewards rewards = new Rewards("꽝,5000,꽝,3000".split(","));
        People people = new People(names);
        int countOfLadder = 5;
        //when
        LadderGame ladderGame = LadderGame.of(people, rewards, countOfLadder);
        OutputView.printLadder(ladderGame);
    }

}