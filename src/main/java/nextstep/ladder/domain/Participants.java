package nextstep.ladder.domain;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Participants {

  private List<Participant> participants;

  public Participants(List<String> names) {
    participants = names.stream()
        .map(Participant::new)
        .collect(Collectors.toList());
  }

  public void printAll() {
    participants.forEach(Participant::print);
    System.out.println();
  }

  public void findResults(Ladder ladder, LadderResults results, ResultMappings resultMappings) {
    IntStream.range(0, participants.size())
        .forEach(i -> resultMappings.add(participants.get(i), results.resultAt(ladder.play(i))));
  }
}
