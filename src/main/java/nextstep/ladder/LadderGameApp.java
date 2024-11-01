package nextstep.ladder;

import nextstep.ladder.controller.LadderGameController;
import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Player;
import nextstep.ladder.domain.Prize;
import nextstep.ladder.service.LadderGameService;

import java.util.List;

public class LadderGameApp {
    private static final LadderGameController controller = new LadderGameController(new LadderGameService());

    public static void main(String[] args) {
        List<Player> players = controller.registerPlayers();
        List<Prize> prizes = controller.decidePrizes(players.size());
        Ladder ladder = controller.makeLadder(players.size());

        controller.showLadderGame(players, ladder, prizes);

        controller.searchResultMultiple(controller.play(players, prizes, ladder), 2);
    }
}
