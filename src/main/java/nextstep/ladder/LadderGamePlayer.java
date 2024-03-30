package nextstep.ladder;

import nextstep.ladder.domain.ladder.Height;
import nextstep.ladder.domain.player.Players;
import nextstep.ladder.view.InputView;

public class LadderGamePlayer {

    private void play() {
        final Players players = new Players(InputView.playerNames());

        final Height height = new Height(InputView.ladderHeight());
        if (height.isZero()) {
            return;
        }
    }

    public static void main(String[] args) {
        final LadderGamePlayer player = new LadderGamePlayer();
        player.play();
    }
}
