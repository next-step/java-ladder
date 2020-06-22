package laddergame.model;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ResultPlayerNamesTest {

  @ParameterizedTest
  @MethodSource("namesProviderWithLength")
  void createByNamesWithLength(List<String> nameList, String namesStr,
      int length) {
    String[] nameStrArray = nameList.toArray(new String[0]);

    ResultNames namesCreatedByList = ResultNames.createByNamesWithLength(nameStrArray, length);
    ResultNames namesCreatedByStr = ResultNames.createByNamesWithLength(namesStr.split(","), length);

    assertThat(namesCreatedByList).isEqualTo(namesCreatedByStr);
  }

  public static Stream<Arguments> namesProviderWithLength() {
    return Stream.of(
        arguments(
            Arrays.asList("test1", "test2", "test3", "test4"),
            "test1, test2, test3, test4",
            4
        )
    );
  }

  @ParameterizedTest
  @MethodSource("namesProviderWithWrongLength")
  @DisplayName("입력길이가 다른 경우")
  void createByNamesWithLength_Wrong(List<String> nameStrList, int length) {
    String[] nameStrArray = nameStrList.toArray(new String[0]);
    assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
      ResultNames.createByNamesWithLength(nameStrArray, length);
    });
  }

  public static Stream<Arguments> namesProviderWithWrongLength() {
    return Stream.of(
        arguments(
            Arrays.asList("test1", "test2", "test3", "test4"),
            3
        ),
        arguments(
            Arrays.asList("test1", "test2", "test3", "test4"),
            5
        )
    );
  }
}