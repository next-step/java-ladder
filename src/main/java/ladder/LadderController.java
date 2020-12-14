package ladder;

import ladder.domain.LadderGame;
import ladder.domain.dto.GameResult;
import ladder.domain.dto.Reward;
import ladder.domain.ladder.Ladder;
import ladder.domain.ladder.RandomLineGenerator;
import ladder.domain.participant.Participants;
import ladder.view.InputView;
import ladder.view.ResultView;

import java.util.Map;

public class LadderController {

    public static void main(String[] args) {


        Participants participants = Participants.of(InputView.inputParticipantPerson());

        Reward reward = new Reward(InputView.inputLadderGameReward());
        LadderGame ladderGame = new LadderGame(new RandomLineGenerator(), reward);

        Ladder ladder = ladderGame.makeLadder(participants.countParticipant() - 1, InputView.inputLadderHeight());

        ResultView.outputLadderGame(participants, ladder, reward);

        GameResult result = ladderGame.play(participants, ladder);

        String userRewardResult = result.search(InputView.inputGameResultOfUser());
        ResultView.gameResult(userRewardResult);

        Map<String, String> allRewardResult = result.searchAll(InputView.inputGameResultOfUser());
        ResultView.gameAllResult(allRewardResult);

    }
}
