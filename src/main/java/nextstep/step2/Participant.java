package nextstep.step2;

public class Participant {

  private final int ParticipantNameMaxLength = 5;

  private String participantName;

  public Participant(String participantName) {
    if (participantName.length() > ParticipantNameMaxLength) {
      throw new IllegalArgumentException();
    }

    this.participantName = participantName;
  }

  @Override
  public boolean equals(Object obj) {
    return this.participantName.equals(((Participant) obj).participantName);
  }

}
