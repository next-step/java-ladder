package ladder;

import java.util.List;

public class LadderGame {
    private View view = new View();

    public void start() {
        Print.joinGame();

        List<String> input = Input.players();
        Players players = new Players(input);

        Print.howManyLadders();
        int ladders = Input.integer();

        view.laddersView(players, ladders);
    }
}
