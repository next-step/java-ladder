package nextstep.ladder;

import nextstep.ladder.view.InputVIew;

import java.util.List;

public class LadderGameApplication {
    public static void main(String[] args) {
        List<String> players = InputVIew.inputPlayers();
        players.forEach(System.out::println);
    }
}
