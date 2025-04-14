package nextstep.ladder;

import java.util.List;

public class MappingTable implements Mapping {
  private final Participants participants;
  private final Results results;

  public MappingTable(Participants participants, Results results) {
    if (participants.count() != results.values().size()) {
      throw new IllegalArgumentException("참가자 수와 결과 수는 같아야 합니다.");
    }
    this.participants = participants;
    this.results = results;
  }

  @Override
  public int indexOf(String name) {
    return participants.indexOf(name)
        .orElseThrow(() -> new IllegalArgumentException("이름이 존재하지 않습니다: " + name));
  }

  @Override
  public String resultOfIndex(int index) {
    return results.get(index);
  }

  @Override
  public List<String> names() {
    return participants.names();
  }
}
