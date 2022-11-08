package ladder;

public class LadderGame {
    public void start() {
        Print.joinGame();

        String input = Input.input();
        Players players = new Players(input);

        Print.howManyLadders();
        int ladders = Input.integer();
    }
}
