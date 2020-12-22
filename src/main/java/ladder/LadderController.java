package ladder;

import ladder.domain.LadderGame;
import ladder.domain.dto.GameResult;
import ladder.domain.dto.Rewards;
import ladder.domain.ladder.Ladder;
import ladder.domain.ladder.LadderFactory;
import ladder.domain.ladder.LadderStructure;
import ladder.domain.ladder.RandomLineGenerator;
import ladder.domain.participant.Participants;
import ladder.view.InputView;
import ladder.view.ResultView;

import java.util.Map;

public class LadderController {

    public static void main(String[] args) {


        Participants participants = Participants.of(InputView.inputParticipantPerson());

        Rewards rewards = new Rewards(InputView.inputLadderGameReward());

        LadderStructure ladderStructure = new LadderStructure(participants.countParticipant(), InputView.inputLadderHeight());
        Ladder ladder = LadderFactory.makeLadder(ladderStructure, new RandomLineGenerator());

        LadderGame ladderGame = new LadderGame(participants, ladder);

        ResultView.outputLadderGame(ladderGame.getLadderMaterial(), rewards);

        GameResult result = ladderGame.play(rewards);

        String userRewardResult = result.search(InputView.inputGameResultOfUser());
        ResultView.gameResult(userRewardResult);

        Map<String, String> allRewardResult = result.searchAll(InputView.inputGameResultOfUser());
        ResultView.gameAllResult(allRewardResult);

    }
}
