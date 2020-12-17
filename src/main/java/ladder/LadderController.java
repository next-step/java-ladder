package ladder;

import ladder.domain.LadderGame;
import ladder.domain.dto.GameResult;
import ladder.domain.dto.Rewards;
import ladder.domain.ladder.Ladder;
import ladder.domain.ladder.RandomLineGenerator;
import ladder.domain.participant.Participants;
import ladder.view.InputView;
import ladder.view.ResultView;

import java.util.Map;

public class LadderController {

    public static void main(String[] args) {


        Participants participants = Participants.of(InputView.inputParticipantPerson());

        Rewards rewards = new Rewards(InputView.inputLadderGameReward());
        LadderGame ladderGame = new LadderGame(new RandomLineGenerator(), rewards);

        Ladder ladder = ladderGame.makeLadder(participants.countParticipant() - 1, InputView.inputLadderHeight());

        ResultView.outputLadderGame(participants, ladder, rewards);

        GameResult result = ladderGame.play(participants, ladder);

        String userRewardResult = result.search(InputView.inputGameResultOfUser());
        ResultView.gameResult(userRewardResult);

        Map<String, String> allRewardResult = result.searchAll(InputView.inputGameResultOfUser());
        ResultView.gameAllResult(allRewardResult);

    }
}
