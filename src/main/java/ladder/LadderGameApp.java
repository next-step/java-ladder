package ladder;

import ladder.model.Players;
import ladder.view.InputView;

public class LadderGameApp {

    public static void main(String[] args) {
        try {
            Players players = InputView.getPlayers();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
