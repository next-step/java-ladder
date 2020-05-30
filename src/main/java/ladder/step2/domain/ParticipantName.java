package ladder.step2.domain;

import ladder.step2.exception.ParticipantNameMaximumSizeException;

import java.util.HashMap;

public class ParticipantName {
  private static final HashMap<String, ParticipantName> factory = new HashMap<>();

  private final String name;

  private ParticipantName (String name) {
    this.name = name;
  }

  public ParticipantName valueOf (String name) {
    validate(name);
    ParticipantName already = factory.get(name);
    if (already != null) {
      return already;
    }
    return new ParticipantName(name);
  }

  public static void validate (String name) {
    if (name.length() > 5) {
      throw new ParticipantNameMaximumSizeException();
    }
  }
}
