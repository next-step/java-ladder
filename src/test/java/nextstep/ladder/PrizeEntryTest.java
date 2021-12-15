package nextstep.ladder;

import nextstep.ladder.domain.entity.PrizeEntry;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PrizeEntryTest {


  @ParameterizedTest
  @MethodSource("makeEntryMap")
  @DisplayName("각 이름별 사다리 위치를 가져온다.")
  void findByName(Map<String, Integer> map, String key, int value) {
    PrizeEntry entry = new PrizeEntry(map);

    assertEquals(value, entry.findByName(key));
  }

  private static Stream<Arguments> makeEntryMap() {
    Map<String, Integer> map = new HashMap<>();
    map.put("pobi", 1);
    map.put("honux", 3);
    map.put("crong", 2);
    map.put("jk", 4);

    return Stream.of(
            Arguments.of(map, "pobi", 1),
            Arguments.of(map, "honux", 3),
            Arguments.of(map, "crong", 2),
            Arguments.of(map, "jk", 4));
  }

}