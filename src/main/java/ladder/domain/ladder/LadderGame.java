package ladder.domain.ladder;

import ladder.domain.participant.Participant;
import ladder.domain.participant.Participants;
import ladder.domain.prize.Prize;
import ladder.domain.prize.Prizes;

public class LadderGame {

  private final Ladder ladder;
  private final Participants participants;

  public LadderGame(Ladder ladder, Participants participants) {
    this.ladder = ladder;
    this.participants = participants;
  }

  public int getPrizeIndex(Participant participant) {
    int startIndex = participants.indexOf(participant);
    return ladder.getIndexOfResult(startIndex);
  }


  public MatchResults play(Prizes prizes) {
    MatchResults matchResults = new MatchResults();
    for (Participant participant : participants.getParticipants()) {
      int prizeIndex = getPrizeIndex(participant);
      Prize prize = prizes.getPrize(prizeIndex);
      matchResults.addMatchResult(participant, prize);
    }
    return matchResults;
  }
}
