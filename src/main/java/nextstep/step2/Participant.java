package nextstep.step2;

public class Participant {

  private final int PARTICIPANT_NAME_MAX_LENGTH = 5;

  private String participantName;

  public Participant(String participantName) {
    if (participantName.length() > PARTICIPANT_NAME_MAX_LENGTH) {
      throw new IllegalArgumentException();
    }

    this.participantName = participantName;
  }

  @Override
  public boolean equals(Object obj) {
    return this.participantName.equals(((Participant) obj).participantName);
  }

}
