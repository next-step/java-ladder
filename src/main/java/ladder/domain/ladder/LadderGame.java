package ladder.domain.ladder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import ladder.domain.participant.Participant;
import ladder.domain.participant.Participants;
import ladder.domain.prize.Prize;
import ladder.domain.prize.Prizes;

public class LadderGame {

  private final Ladder ladder;
  private final Participants participants;
  private final Prizes prizes;
  private final Map<Participant, Prize> results = new HashMap<>();

  public LadderGame(Ladder ladder, Participants participants, Prizes prizes) {
    this.ladder = ladder;
    this.participants = participants;
    this.prizes = prizes;
  }

  public Prize getPrize(Participant participant) {
    if (results.containsKey(participant)) {
      return results.get(participant);
    }
    int startIndex = participants.indexOf(participant);
    int endIndex = ladder.getIndexOfResult(startIndex);
    Prize prize = prizes.getPrize(endIndex);
    results.put(participant, prize);
    return prize;
  }

  public List<MatchResult> getAllResults() {
    return participants.getParticipants().stream()
        .map(participant -> new MatchResult(participant, getPrize(participant)))
        .collect(Collectors.toList());
  }
}
