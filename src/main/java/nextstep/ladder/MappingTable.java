package nextstep.ladder;

import java.util.List;
import java.util.OptionalInt;

public class MappingTable {
  private final Participants participants;
  private final Results results;

  public MappingTable(Participants participants, Results results) {
    if (participants.count() != results.values().size()) {
      throw new IllegalArgumentException("참가자 수와 결과 수는 같아야 합니다.");
    }
    this.participants = participants;
    this.results = results;
  }

  public int indexOf(String name) {
    OptionalInt index = participants.indexOf(name);
    if (index.isEmpty()) {
      throw new IllegalArgumentException("이름이 존재하지 않습니다: " + name);
    }
    return index.getAsInt();
  }

  public String resultAt(int index) {
    return results.get(index);
  }

  public List<String> names() {
    return participants.names();
  }

}
