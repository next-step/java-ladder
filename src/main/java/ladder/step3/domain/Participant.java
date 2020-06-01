package ladder.step3.domain;

import ladder.step3.exception.ParticipantNameMaximumSizeException;

import java.util.HashMap;
import java.util.Map;

public class Participant {
  private static final Map<String, Participant> FACTORY = new HashMap<>();

  private final String value;

  private Participant(String value) {
    this.value = value;
  }

  public static Participant valueOf (String value) {
    validate(value);
    if (FACTORY.get(value) == null) {
      FACTORY.put(value, new Participant(value));
    }
    return FACTORY.get(value);
  }

  public static void validate (String value) {
    if (value.length() > 5) {
      throw new ParticipantNameMaximumSizeException();
    }
  }

  public String getValue () {
    return value;
  }
}
