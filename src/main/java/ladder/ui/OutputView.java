package ladder.ui;

import ladder.domain.Line;
import ladder.domain.User;

import java.util.List;

public class OutputView {

    private OutputView(){
    }

    public static void drawLadder(List<String> ladder, List<User> users){
        System.out.print(users);
        System.out.println(ladder);
    }
}
