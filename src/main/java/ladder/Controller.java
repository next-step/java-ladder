package ladder;

import ladder.domain.LadderGame;

public class Controller {
    public static void main(String[] args) {
        LadderGame game = new LadderGame(4, 3);
        System.out.println(game.getLadder());

        game = new LadderGame(3, 5);
        System.out.println(game.getLadder());
    }
}
