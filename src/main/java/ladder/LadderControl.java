package ladder;

import ladder.domain.*;
import ladder.view.View;

import java.util.List;

public class LadderControl {
    public void play() {
        List<String> names = View.names();
        Players players = new Players(names);

        int height = View.height();

        Linker linker = new Linker(new RandomLinkSelector());
        Ladder ladder = new Ladder(height, players.count(), linker);
        View.printResult(players, ladder);
    }
}
