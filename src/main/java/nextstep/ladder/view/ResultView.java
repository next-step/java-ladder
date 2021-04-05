package nextstep.ladder.view;

import java.util.List;

public class ResultView {

    private ResultView() {}


    public static void showPlayers(String playerNames) {
        System.out.println(playerNames);
    }

    public static void showLadder(List<String> ladder) {
        ladder.forEach(System.out::println);
    }
}
