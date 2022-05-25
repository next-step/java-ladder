package nextstep.ladder;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Player;
import nextstep.ladder.domain.RandomPointCreationRule;
import nextstep.ladder.view.Input;
import nextstep.ladder.view.Output;

import java.util.List;

public class LadderController {

    private static final int DIFFERENCE_BETWEEN_PLAYER_CNT_AND_POINT_CNT = 1;

    public void start(){
        List<Player> players =  Input.readUserNames();
        int maxLadderLength = Input.readMaxLadderLength();
        Ladder ladder = Ladder.of(maxLadderLength, players.size()-DIFFERENCE_BETWEEN_PLAYER_CNT_AND_POINT_CNT, new RandomPointCreationRule());

        Output.printNameList(players);
        Output.printLadder(ladder);
    }
}
