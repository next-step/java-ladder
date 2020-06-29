package laddergame.model;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LadderTest {

  @ParameterizedTest
  @MethodSource("heightAndNamesProvider")
  void createByHeightAndNamesStrArr(PositiveNumber height, String namesStr) {
    String[] nameStrArr = namesStr.split(",");
    PlayerNames playerNames = PlayerNames.createBy(namesStr.split(","));

    Ladder ladder = Ladder.createByHeightAndCountOfPerson(height, playerNames.getCountOfNames());

    assertThat(ladder.getLines().size()).isEqualTo(height.getValue());

    for (Line line : ladder.getLines()) {
      assertThat(line.getPoints().size()).isEqualTo(nameStrArr.length);
    }
  }

  public static Stream<Arguments> heightAndNamesProvider() {
    return Stream.of(
        arguments(
            new PositiveNumber(1),
            "test1, test2, test3, test4"
        ),
        arguments(
            new PositiveNumber(5),
            "test1, test2, test3, test4"
        ),
        arguments(
            new PositiveNumber(5),
            "test1, test2, test3, test4, test5, test6, test7"
        )
    );
  }

  @ParameterizedTest
  @MethodSource("createByHeightAndCountOfPerson2")
  @DisplayName("사다리 생성 테스트")
  void createByHeightAndCountOfPerson2(PositiveNumber height, String namesStr) {
    String[] nameStrArr = namesStr.split(",");
    PlayerNames playerNames = PlayerNames.createBy(namesStr.split(","));

    Ladder ladder = Ladder.createByHeightAndCountOfPerson2(height, playerNames.getCountOfNames());

    assertThat(ladder.getLines().size()).isEqualTo(height.getValue());

    for (Line line : ladder.getLines()) {
      assertThat(line.getPoints().size()).isEqualTo(nameStrArr.length);
    }
    System.out.println(ladder);
  }

  public static Stream<Arguments> createByHeightAndCountOfPerson2() {
    return Stream.of(
        arguments(
            new PositiveNumber(1),
            "test1, test2, test3, test4"
        ),
        arguments(
            new PositiveNumber(5),
            "test1, test2, test3, test4"
        ),
        arguments(
            new PositiveNumber(5),
            "test1, test2, test3, test4, test5, test6, test7"
        )
    );
  }

  @ParameterizedTest
  @MethodSource("findResultPositionOf2")
  @DisplayName("결과 찾기 테스트")
  void findResultPositionOf2(Ladder ladder, Map<Integer, Integer> resultMap) {
    resultMap.entrySet().forEach(entry -> {
      assertThat(ladder.findResultPositionOf2(entry.getKey())).isEqualTo(entry.getValue());
    });
  }

  static Stream<Arguments> findResultPositionOf2() {
    Point point0_1 = new Point(0);
    Point point1_0 = point0_1.createNextWithLinkedBy(true);
    Point point1_2 = new Point(1);
    Point point2_1 = point1_2.createNextWithLinkedBy(true);
//    Point point3 = point2.createNextWithLinkedBy(true);
//
    return Stream.of(
        arguments(
            new Ladder(Arrays.asList(
                new Line(
                    Arrays.asList(
                        new Point(0),
                        new Point(1)
                    )
                )
            )),
            new HashMap<Integer, Integer>() {{
              put(0, 0);
              put(1, 1);
            }}
        ),
        arguments(
            new Ladder(Arrays.asList(
                new Line(
                    Arrays.asList(
                        point0_1,
                        point1_0,
                        new Point(2)
                    )
                ),
                new Line(
                    Arrays.asList(
                        new Point(0),
                        point1_2,
                        point2_1
                    )
                )
            )),
            new HashMap<Integer, Integer>() {{
              put(0, 2);
              put(1, 0);
              put(2, 1);
            }}
        )
    );
  }

  @ParameterizedTest
  @MethodSource("provideLadder")
  void getLineDTOs(Ladder ladder) {
    StringBuilder sb = new StringBuilder();

    ladder.getLineDTOs().forEach(lineDTO -> {
      sb.append(lineDTO.getLineWithMappedPoint())
          .append(System.lineSeparator());
    });

    System.out.println(sb);
  }

  static Stream<Arguments> provideLadder() {
    Point point0_1 = new Point(0);
    Point point1_0 = point0_1.createNextWithLinkedBy(true);
    Point point1_2 = new Point(1);
    Point point2_1 = point1_2.createNextWithLinkedBy(true);
//    Point point3 = point2.createNextWithLinkedBy(true);
//
    return Stream.of(
        arguments(
            new Ladder(Arrays.asList(
                new Line(
                    Arrays.asList(
                        new Point(0),
                        new Point(1)
                    )
                )
            ))
        ),
        arguments(
            new Ladder(Arrays.asList(
                new Line(
                    Arrays.asList(
                        point0_1,
                        point1_0,
                        new Point(2)
                    )
                ),
                new Line(
                    Arrays.asList(
                        new Point(0),
                        point1_2,
                        point2_1
                    )
                )
            ))
        ));
  }
}