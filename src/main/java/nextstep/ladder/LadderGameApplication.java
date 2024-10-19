package nextstep.ladder;

import nextstep.ladder.view.InputView;

import java.util.List;

public class LadderGameApplication {
    public static void main(String[] args) {
        List<String> players = InputView.inputPlayers();
        players.forEach(System.out::println);
        int height = InputView.inputLadderHeight();
        System.out.println(height);
    }
}
