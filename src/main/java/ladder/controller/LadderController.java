package ladder.controller;

import ladder.domain.Line;
import ladder.domain.Member;
import ladder.service.LadderGame;

import java.util.List;

public class LadderController {
    private final InputView inputView;
    private final ResultView resultView;

    public LadderController(InputView inputView, ResultView resultView) {
        this.inputView = inputView;
        this.resultView = resultView;
    }

    public void play() {
        LadderGame game = LadderGame.getInstance();
        List<Member> playMembers = inputView.getPlayMembers();
        int ladderHeight = inputView.getLadderHeight();

        List<Line> ladders = game.createLadders(playMembers, ladderHeight);
        resultView.printLadders(ladders);
        System.out.println(ladders);
    }
}
