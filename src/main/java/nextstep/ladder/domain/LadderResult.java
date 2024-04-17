package nextstep.ladder.domain;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LadderResult {
  private final Map<Person, String> peopleResult;
  private final List<Line> ladderResults;

  public LadderResult(Map<Person, String> peopleResult, List<Line> ladderResults) {
    this.peopleResult = peopleResult;
    this.ladderResults = ladderResults;
  }

  public List<String> getPeopleNames() {
    return peopleResult.keySet().stream().map(Person::getName).collect(Collectors.toList());
  }

  public List<Line> getLadderResults() {
    return ladderResults;
  }

  public Map<Person, String> getResultByName(Person person) {
    if(person.isSameName("all")) {
      return peopleResult;
    }
    return Map.of(person, peopleResult.get(person));
  }
}
