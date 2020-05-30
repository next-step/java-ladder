package ladder.step2.domain;

import ladder.step2.exception.ParticipantsMinimumSizeException;

import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class Participants {
  private final TreeSet<Participant> participants;

  private Participants (TreeSet<Participant> participants) {
    this.participants = participants;
  }

  public static Participants ofString (String participants) {
    return Arrays.stream(participants.split(","))
                 .map(Participant::valueOf)
                 .collect(collectingAndThen(toList(), Participants::ofList));
  }

  public static Participants ofList (List<Participant> participants) {
    return of(new TreeSet<>(participants));
  }

  public static Participants of (TreeSet<Participant> participants) {
    validate(participants.size());
    return new Participants(participants);
  }

  private static void validate (int size) {
    if (size < 2) {
      throw new ParticipantsMinimumSizeException();
    }
  }
}
