package ladder;

import ladder.domain.Ladder;
import ladder.domain.Link;
import ladder.domain.LinkSelector;
import ladder.domain.Linker;
import ladder.view.*;

import java.util.List;

public class LadderMain {
    public static void main(String[] args) {
        List<String> p = View.players();
        int height = View.height();
        View.printPlayers(p);
        Linker linker = new Linker(() -> {
            int selected = (int) Math.round(Math.random());
            return Link.values()[selected];
        });

        //TODO PLAYER Class  만들기

        Ladder ladder = new Ladder(height, 5, linker);
        View.printLadder(ladder);
    }
}
