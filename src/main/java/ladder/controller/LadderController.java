package ladder.controller;

import ladder.domain.LadderResult;
import ladder.domain.Ladder;
import ladder.domain.Member;
import ladder.domain.Members;
import ladder.domain.RandomStrategy;
import ladder.domain.Rewords;

public class LadderController {
    private final InputView inputView;
    private final ResultView resultView;

    public LadderController(InputView inputView, ResultView resultView) {
        this.inputView = inputView;
        this.resultView = resultView;
    }

    public void play() {
        RandomStrategy randomStrategy = RandomStrategy.getInstance();
        Members playMembers = inputView.getPlayMembers();
        Rewords rewords = inputView.getPlayRewords();
        int ladderHeight = inputView.getLadderHeight();

        Ladder ladder = new Ladder(playMembers.getSize(), ladderHeight, randomStrategy);
        resultView.printLadders(playMembers, ladder, rewords);

        LadderResult result = ladder.playLadders(playMembers, rewords);
        Member memberResult = inputView.getMemberResult();
        resultView.printResult(result, memberResult);
    }
}
