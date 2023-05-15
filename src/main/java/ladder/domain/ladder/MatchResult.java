package ladder.domain.ladder;


import ladder.domain.participant.Participant;
import ladder.domain.participant.Participants;
import ladder.domain.prize.Prize;

public class MatchResult {

  private final Participant participant;
  private final Prize prize;

  public MatchResult(Participant participant, Prize prize) {
    this.participant = participant;
    this.prize = prize;
  }

  public String getMatchResult() {
  return participant.getName().name() + " : " + prize.getPrize();
  }

  public String getPrize() {
    return prize.getPrize();
  }

  public String getParticipantName() {
    return participant.getName().name();
  }
}
