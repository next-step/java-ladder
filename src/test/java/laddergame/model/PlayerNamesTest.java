package laddergame.model;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class PlayerNamesTest {

  @ParameterizedTest
  @MethodSource("namesProvider")
  @DisplayName("배열로 생성 테스트")
  void createBy(List<String> nameStrList, String namesStr) {
    PlayerNames playerNamesCreatedByList = PlayerNames.createBy(nameStrList.toArray(new String[0]));
    PlayerNames playerNamesCreatedByStr = PlayerNames.createBy(namesStr.split(","));

    assertThat(playerNamesCreatedByList).isEqualTo(playerNamesCreatedByStr);
  }

  public static Stream<Arguments> namesProvider() {
    return Stream.of(
        arguments(
            Arrays.asList("test1", "test2", "test3", "test4"),
            "test1, test2, test3, test4"
        )
    );
  }
}