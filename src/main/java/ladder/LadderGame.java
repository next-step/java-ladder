package ladder;

public class LadderGame {
    private View view = new View();

    public void start() {
        Print.joinGame();

        String input = Input.input();
        Players players = new Players(input);

        Print.howManyLadders();
        int ladders = Input.integer();

        view.laddersView(players, ladders);
    }
}
