package laddergame.model;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class NamesTest {

  @ParameterizedTest
  @MethodSource("nameStrArrProvider")
  void createByNameStrArr(List<String> nameStrList, String namesStr) {
    Names namesCreatedByList = Names.createByNameStrArr(nameStrList.toArray(new String[0]));
    Names namesCreatedByStr = Names.createByNameStrArr(namesStr.split(","));

    assertThat(namesCreatedByList).isEqualTo(namesCreatedByStr);
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