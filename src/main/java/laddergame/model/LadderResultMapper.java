package laddergame.model;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LadderResultMapper {

  private final Map<Name, Name> ladderResultMap;

  public LadderResultMapper(Map<Name, Name> ladderResultMap) {
    this.ladderResultMap = ladderResultMap;
  }

  public static LadderResultMapper createBy(Ladder ladder, PlayerNames players, ResultNames results) {
    return new LadderResultMapper(Stream.iterate(0, positionNum -> positionNum + 1)
        .limit(players.getCountOfNames())
        .collect(Collectors.toMap(
            players::getNameByIndex,
            positionNum -> results.getNameByIndex(ladder.getResultPosition(positionNum)),
            (x, y) -> x,
            LinkedHashMap::new
        )));
  }

  public Name getResultOf(Name playerName) {
    Optional<Name> result = Optional.ofNullable(playerName);

    return result.map(name -> ladderResultMap.get(name))
        .orElseThrow(PlayerNotExistException::new);
  }

  public Set<Entry<Name, Name>> getEntrySet() {
    return Collections.unmodifiableSet(ladderResultMap.entrySet());
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LadderResultMapper that = (LadderResultMapper) o;
    return ladderResultMap.equals(that.ladderResultMap);
  }

  @Override
  public int hashCode() {
    return Objects.hash(ladderResultMap);
  }

  @Override
  public String toString() {
    return "LadderResultMap{" +
        "ladderResultMap=" + ladderResultMap +
        '}';
  }
}
