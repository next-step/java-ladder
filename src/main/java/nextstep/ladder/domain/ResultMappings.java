package nextstep.ladder.domain;

import java.util.List;

public class ResultMappings {

  private final List<ResultMapping> mappings;

  public ResultMappings() {
    this.mappings = new java.util.ArrayList<>();
  }

  void add(Participant p, LadderResult r) {
    mappings.add(new ResultMapping(p, r));
  }

  public void printFor(String name) {
    mappings.stream()
        .filter(mapping -> mapping.match(name))
        .map(ResultMapping::printSingle)
        .forEach(System.out::print);
  }

  public void printAll() {
    mappings.forEach(ResultMapping::print);
  }
}
