package ladder;

import ladder.domain.*;
import ladder.view.View;

import java.util.List;

public class LadderControl {
    public void play() {
        List<String> names = View.names();
        Players players = new Players(names);

        int height = View.height();

        Ladder ladder = new Ladder(height, players.count(), new RandomLinkSelector());
        View.printResult(players, ladder);
    }
}
