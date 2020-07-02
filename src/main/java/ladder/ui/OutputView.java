package ladder.ui;

import ladder.domain.Ladder;
import ladder.domain.Users;

public class OutputView {

    private OutputView(){
    }

    public static void drawLadder(Ladder ladder, Users users){
        System.out.println(users);
        System.out.println(ladder);
    }
}
