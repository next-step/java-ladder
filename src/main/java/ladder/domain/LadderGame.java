package ladder.domain;


import ladder.domain.dto.GameResult;
import ladder.domain.dto.LadderMaterial;
import ladder.domain.dto.Rewards;
import ladder.domain.ladder.Ladder;
import ladder.domain.participant.Participants;
import ladder.exception.CanNotPlayGameException;

public class LadderGame {

    private Participants participants;
    private Ladder ladder;

    public LadderGame(Participants participants, Ladder ladder) {
        this.participants = participants;
        this.ladder = ladder;
    }

    public GameResult play(Rewards rewards){
        validateRewardsAndParticipantsCountMatch(rewards);
        for (int i = 0; i < ladder.sizeHeight(); i++) {
            ladder.movePosition(i, participants);
        }

        return new GameResult(participants.getParticipants(), rewards);
    }

    private void validateRewardsAndParticipantsCountMatch(Rewards rewards) {
        if(rewards.getRewards().size() != participants.countParticipant()) {
            throw new CanNotPlayGameException();
        }
    }

    public LadderMaterial getLadderMaterial() {
        return new LadderMaterial(participants.getParticipantNames(), ladder);
    }
}
