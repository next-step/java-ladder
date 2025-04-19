package nextstep.ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Participants {

  private List<Participant> participants;

  public Participants(String[] names) {
    participants = Arrays.stream(names)
        .map(Participant::new).collect(Collectors.toList());
  }

  public void printAll() {
    participants.forEach(Participant::print);
    System.out.println();
  }

}
