package nextstep.ladder;

import java.util.List;

public class LadderGame {

    public static void main(String[] args) {
        List<Player> players = InputView.getPlayers();
        int height = InputView.getHeight();

        Ladder ladder = LadderFactory.generate(height, players.size(), new RandomPointGenerator());

        ResultView.printLadder(ladder, players);
    }


}
