package nextstep.laddar;

import java.util.List;
import nextstep.laddar.view.InputView;
import nextstep.laddar.view.ResultView;

public class app {

    public static void main(String[] args) {
        Users userNames = InputView.getUserName();
        int height = InputView.getHeight();
        Ladder laddar = new Ladder(height, userNames.getSize(), new RandomGenerator());
        ResultView.printNames(userNames.getUsers());
        ResultView.printLaddar(laddar);
    }

}
