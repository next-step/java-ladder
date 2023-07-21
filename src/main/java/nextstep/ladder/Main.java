package nextstep.ladder;

import nextstep.ladder.controller.LadderController;
import nextstep.ladder.domain.Players;
import nextstep.ladder.view.ConsoleLadderInputView;
import nextstep.ladder.view.ConsoleLottoOutputView;
import nextstep.ladder.view.LadderView;

public class Main {

    public static void main(String[] args) {
        try {
            LadderController ladderController = new LadderController(new LadderView(new ConsoleLadderInputView(), new ConsoleLottoOutputView()));

            Players players = ladderController.ladderGamePlayers();

            ladderController.createLadder(players);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
