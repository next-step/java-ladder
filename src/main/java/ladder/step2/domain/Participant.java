package ladder.step2.domain;

import ladder.step2.exception.ParticipantNameMaximumSizeException;

import java.util.HashMap;

public class Participant {
  private static final HashMap<String, Participant> factory = new HashMap<>();

  private final String name;

  private Participant(String name) {
    this.name = name;
  }

  public static Participant valueOf (String name) {
    validate(name);
    Participant already = factory.get(name);
    if (already != null) {
      return already;
    }
    return new Participant(name);
  }

  public static void validate (String name) {
    if (name.length() > 5) {
      throw new ParticipantNameMaximumSizeException();
    }
  }
}
