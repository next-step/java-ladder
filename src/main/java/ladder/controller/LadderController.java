package ladder.controller;

import ladder.domain.Line;
import ladder.domain.Member;
import ladder.domain.RandomStrategy;
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
        RandomStrategy randomStrategy = RandomStrategy.getInstance();
        List<Member> playMembers = inputView.getPlayMembers();
        int ladderHeight = inputView.getLadderHeight();

        List<Line> ladders = game.createLadders(playMembers, ladderHeight, randomStrategy);
        resultView.printResults(playMembers, ladders);
    }
}
