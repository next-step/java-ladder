package ladder.step3.domain;

import ladder.step3.exception.ParticipantsMinimumSizeException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class Participants {
  private final List<Participant> participants;

  private Participants (List<Participant> participants) {
    this.participants = participants;
    validate();
  }

  public static Participants ofString (String participants) {
    return Arrays.stream(participants.split(","))
                 .map(Participant::valueOf)
                 .collect(collectingAndThen(toList(), Participants::new));
  }

  private void validate () {
    if (participants.size() < 2) {
      throw new ParticipantsMinimumSizeException();
    }
  }

  public Stream<Participant> stream () {
    return participants.stream();
  }

  public int size () {
    return participants.size();
  }
}
