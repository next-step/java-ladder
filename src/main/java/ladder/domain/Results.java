package ladder.domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;

public class Results {

  private final List<Result> results;
  private final HashMap<Name, Result> gameResult = new LinkedHashMap<>();

  public Results(List<Result> results) {
    this.results = results;
  }

  public List<Result> result() {
    return Collections.unmodifiableList(results);
  }

  public void put(Name name, int position) {
    gameResult.put(name, results.get(position));
  }

  public HashMap<Name, Result> gameResult() {
    return gameResult;
  }

  public String findOne(String name) {
    return gameResult().entrySet()
        .stream()
        .filter(e -> e.getKey().getName().equals(name))
        .map(Entry::getValue)
        .findFirst()
        .map(Result::toString)
        .orElseThrow(() -> new IllegalArgumentException("입력한 참가자에 대한 결과가 없습니다."));
  }
}
