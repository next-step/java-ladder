package laddergame.model;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class PlayersTest {

  @ParameterizedTest
  @MethodSource("nameStrArrProvider")
  void createByNameStrArr(List<String> nameStrList, String namesStr) {
    Players playersCreatedByList = Players.createByNameStrArr(nameStrList.toArray(new String[0]));
    Players playersCreatedByStr = Players.createByNameStrArr(namesStr.split(","));

    assertThat(playersCreatedByList).isEqualTo(playersCreatedByStr);
  }

  public static Stream<Arguments> nameStrArrProvider() {
    return Stream.of(
        arguments(
            Arrays.asList("test1", "test2", "test3", "test4"),
            "test1, test2, test3, test4"
        )
    );
  }
}