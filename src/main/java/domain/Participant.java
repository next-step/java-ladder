package domain;

public class Participant {

  public final static int MAXIMUM_NAME_LENGTH = 5;

  private String name;

  public Participant(String name) {

    if (name == null || name.isEmpty() || name.length() > MAXIMUM_NAME_LENGTH) {
      throw new IllegalArgumentException();
    }
    this.name = name;
  }

  public String getName() {
    return this.name;
  }
}
