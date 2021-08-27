package nextstep.ladder;

import nextstep.ladder.domain.Height;
import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Players;
import nextstep.ladder.view.HeightConsoleInput;
import nextstep.ladder.view.LadderConsoleOutput;
import nextstep.ladder.view.PlayerConsoleInput;
import nextstep.ladder.view.PlayerConsoleOutput;

public class LadderGame {

    public static void main(String[] args) {
        Players players = new Players(PlayerConsoleInput.askPlayers());
        Height height = new Height(HeightConsoleInput.askHeight());
        Ladder ladder = new Ladder(players, height);
        PlayerConsoleOutput.print(players.toDto());
        LadderConsoleOutput.print(ladder.getLadderBarStatus());
    }
}
