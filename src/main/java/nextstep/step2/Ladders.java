package nextstep.step2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Ladders {

  List<Participant> participants;

  public Ladders(String participants) {
    this.participants = Arrays.asList(participants.split(",")).stream()
        .map(Participant::new).collect(Collectors.toList());
  }

  public int getParticipantsSize() {
    return participants.size();
  }

  public Participant getParticipant(int index) {
    return participants.get(index);
  }

}
