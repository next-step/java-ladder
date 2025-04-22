package nextstep.ladder.domain;

public class ResultMapping {
  private final Participant participant;
  private final LadderResult result;

  ResultMapping(Participant participant, LadderResult result) {
    this.participant = participant;
    this.result = result;
  }

  boolean match(String name) {
    return participant.matchName(name);
  }

  void print() {
    System.out.println(participant.value() + " : " + result.value());
  }

  String printSingle() {
    return result.value() + "\n";
  }
}
