package nextstep.ladder;

import nextstep.ladder.view.ResultView;

import java.util.List;

public class LadderGame {

    public static void main(String[] args) {
        int countOfPerson = 3;
        int maxHeightOfLadder = 3;

        List<String> userNames = List.of("crong", "honux", "pobi");


        Ladder ladder = new Ladder(countOfPerson, maxHeightOfLadder);

        ResultView.printNames(userNames);
        ResultView.printLadder(ladder);
    }
}
