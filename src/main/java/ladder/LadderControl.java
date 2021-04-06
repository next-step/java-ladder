package ladder;

import ladder.domain.Ladder;
import ladder.domain.Link;
import ladder.domain.Linker;
import ladder.domain.Player;
import ladder.view.View;

import java.util.List;

public class LadderControl {
    public void play() {
        List<String> names = View.names();
        Player player = new Player(names);

        int height = View.height();

        Linker linker = new Linker(() -> {
            int selected = (int) Math.round(Math.random());
            return Link.values()[selected];
        });

        Ladder ladder = new Ladder(height, player.count(), linker);
        View.printResult(player, ladder);
    }
}
