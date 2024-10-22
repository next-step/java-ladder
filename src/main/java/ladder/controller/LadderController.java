package ladder.controller;

import ladder.domain.LadderResult;
import ladder.domain.Lines;
import ladder.domain.Member;
import ladder.domain.Members;
import ladder.domain.RandomStrategy;
import ladder.domain.Reword;
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
        Members playMembers = inputView.getPlayMembers();
        List<Reword> rewords = inputView.getPlayRewords();
        int ladderHeight = inputView.getLadderHeight();

        Lines lines = game.createLadders(playMembers.getSize(), ladderHeight, randomStrategy);
        resultView.printLadders(playMembers, lines, rewords);

        LadderResult result = lines.playLadders(playMembers, rewords);
        Member memberResult = inputView.getMemberResult();
        resultView.printResult(result, memberResult);
    }
}
