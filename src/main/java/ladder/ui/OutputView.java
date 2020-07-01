package ladder.ui;

import ladder.domain.Ladder;
import ladder.domain.Line;
import ladder.domain.User;
import ladder.domain.Users;

import java.util.List;

public class OutputView {

    private OutputView(){
    }

    public static void drawLadder(Ladder ladder, Users users){
        System.out.println(users);
        System.out.println(ladder);
    }
}
