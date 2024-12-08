package nextstep.laddergame;

import nextstep.laddergame.domain.Ladder;
import nextstep.laddergame.domain.LadderResult;
import nextstep.laddergame.service.PlayResult;
import nextstep.laddergame.service.LadderFactory;
import nextstep.laddergame.service.RandomLadderFactory;
import nextstep.laddergame.service.RandomLineGenerator;
import nextstep.laddergame.view.InputView;
import nextstep.laddergame.view.OutputView;

import java.util.List;

public class LadderGameInterface {

    public static void main(String[] args) {
        List<String> participantsName = InputView.enterParticipantsName();
        Integer ladderMaxHeight = InputView.enterLadderMaxHeight();
        List<String> ladderOutputs = InputView.enterLadderResult(participantsName.size());

        LadderFactory ladderFactory = new RandomLadderFactory();
        Ladder ladder = ladderFactory.createLadder(participantsName.size(), ladderMaxHeight, new RandomLineGenerator());
        OutputView.printLadder(participantsName, ladder, ladderOutputs);

        PlayResult playResult = ladder.play(participantsName.size());
        LadderResult ladderResult = playResult.map(participantsName, ladderOutputs);

        OutputView.printGameResult(ladderResult);
    }
}
