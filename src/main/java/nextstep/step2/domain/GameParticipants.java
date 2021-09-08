package nextstep.step2.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GameParticipants {

  private List<Participant> participants;

  public GameParticipants(String participants) {
    this.participants = Arrays.asList(participants.split(",")).stream()
        .map(Participant::new).collect(Collectors.toList());
  }

  public int getParticipantsSize() {
    return participants.size();
  }

  public Participant getParticipant(int index) {
    return participants.get(index);
  }

  public int getParticipantNameLenth(int index) {
    return getParticipant(index).getParticipantName().length();
  }
}
