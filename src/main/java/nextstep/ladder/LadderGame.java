package nextstep.ladder;

import java.util.List;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.view.OutputView;

public class LadderGame {
    public static void main(String[] args) {
        final List<String> names = List.of("name1", "name2", "name3");
        final int height = 5;
        Ladder ladder = Ladder.of(names, height);

        OutputView.printPlayerList(ladder.playerList());
        System.out.println(ladder.ladder());
    }
}
