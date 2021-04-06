package ladder;

import ladder.domain.*;
import ladder.view.*;

import java.util.List;

public class LadderMain {
    public static void main(String[] args) {
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
