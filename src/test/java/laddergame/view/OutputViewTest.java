package laddergame.view;

import laddergame.domain.Ladder;
import laddergame.domain.Persons;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OutputViewTest {

    @Test
    @DisplayName("프린트 확인")
    void print() {
        //given
        String[] names = "pobi,honux,crong,jk".split(",");
        Persons persons = new Persons(names);
        int countOfLadder = 5;
        //when
        Ladder ladder = new Ladder(persons, countOfLadder);
        OutputView.printLadder(ladder);
    }

}