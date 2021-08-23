package nextstep.ladder.view;

import java.util.Arrays;
import org.w3c.dom.ls.LSOutput;

public class OutputView {

    private static OutputView instance = new OutputView();


    private OutputView() {
    }

    public static OutputView getInstance() {
        return instance;
    }

    public void showLadder(String[] playerNames, int LadderHeight) {
        System.out.println("실행결과");

        Arrays.stream(playerNames).forEach(System.out::println);
        System.out.println(LadderHeight);

    }

}
