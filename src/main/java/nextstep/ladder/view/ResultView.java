package nextstep.ladder.view;

import java.util.List;

public class ResultView {

    public static void printPlayerNames(List<String> playerNames) {
        playerNames.forEach(name -> System.out.printf("%6s", name));
        System.out.println();
    }
}
