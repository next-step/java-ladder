package nextstep.step2;

public class Participant {

  String participantName;

  public Participant(String participantName) {
    this.participantName = participantName;
  }

  @Override
  public boolean equals(Object obj) {
    return this.participantName.equals(((Participant) obj).participantName);
  }

}
