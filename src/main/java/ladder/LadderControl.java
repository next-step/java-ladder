package ladder;

import ladder.domain.*;
import ladder.view.View;

import java.util.List;

public class LadderControl {
    public void play() {
        List<String> names = View.names();
        Players players = new Players(names);

        List<String> items = View.resultItems();
        Goals goals = new Goals(items, players.count());

        int height = View.height();

        Ladder ladder = new Ladder(height, players.count(), new RandomLinkSelector());
        View.printResult(players, ladder);

        String expectedPlayer = View.expectedPlayer();
    }
}
