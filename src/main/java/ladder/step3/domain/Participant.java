package ladder.step3.domain;

import ladder.step3.exception.ParticipantNameMaximumSizeException;

import java.util.HashMap;
import java.util.Map;

public class Participant {
  private static final Map<String, Participant> FACTORY = new HashMap<>();

  private final String name;

  private Participant(String name) {
    this.name = name;
  }

  public static Participant valueOf (String name) {
    validate(name);
    if (FACTORY.get(name) == null) {
      FACTORY.put(name, new Participant(name));
    }
    return FACTORY.get(name);
  }

  public static void validate (String name) {
    if (name.length() > 5) {
      throw new ParticipantNameMaximumSizeException();
    }
  }

  public String getName () {
    return name;
  }
}
