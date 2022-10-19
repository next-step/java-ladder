package laddergame.view;

import laddergame.domain.Ladder;
import laddergame.domain.People;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OutputViewTest {

    @Test
    @DisplayName("프린트 확인")
    void print() {
        //given
        String[] names = "pobi,honux,crong,jk".split(",");
        People persons = new People(names);
        int countOfLadder = 5;
        //when
        Ladder ladder = new Ladder(persons, countOfLadder, null);
        OutputView.printLadder(ladder);
    }

}