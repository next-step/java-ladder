package nextstep.laddar;

import java.util.List;
import nextstep.laddar.view.InputView;
import nextstep.laddar.view.ResultView;

public class app {

    public static void main(String[] args) {
        List<User> userNames = InputView.getUserName();
        int height = InputView.getHeight();
        Laddar laddar = new Laddar(height, userNames.size(), new RandomGenerator());
        ResultView.printNames(userNames);
        ResultView.printLaddar(laddar);
    }

}
