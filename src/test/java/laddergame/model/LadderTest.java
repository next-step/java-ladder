package laddergame.model;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LadderTest {

  @ParameterizedTest
  @MethodSource("createByHeightAndCountOfPerson")
  @DisplayName("사다리 생성 테스트")
  void createByHeightAndCountOfPerson(PositiveNumber height, String namesStr) {
    PlayerNames playerNames = PlayerNames.createBy(namesStr.split(","));

    Ladder ladder = Ladder.createByHeightAndCountOfPerson(height, playerNames.getCountOfNames());

    assertThat(ladder.getLineDTOs().size()).isEqualTo(height.getValue());

    System.out.println(ladder);
  }

  public static Stream<Arguments> createByHeightAndCountOfPerson() {
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
  @MethodSource("findResultPositionOf")
  @DisplayName("결과 찾기 테스트")
  void findResultPositionOf(Ladder ladder, Map<Integer, Integer> resultMap) {
    resultMap
        .forEach((key, value) -> assertThat(ladder.findResultPositionOf(key)).isEqualTo(value));
  }

  static Stream<Arguments> findResultPositionOf() {
    LinkablePoint basicPoint0_1 = BasicPoint.create(0);
    LinkablePoint basicPoint1_0 = basicPoint0_1.createNextWithLinkedBy(true);
    LinkablePoint basicPoint1_2 = BasicPoint.create(1);
    LinkablePoint basicPoint2_1 = basicPoint1_2.createNextWithLinkedBy(true);
//    Point point3 = point2.createNextWithLinkedBy(true);
//
    return Stream.of(
        arguments(
            new Ladder(Arrays.asList(
                new Line(
                    Arrays.asList(
                        BasicPoint.create(0),
                        BasicPoint.create(1)
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
                        basicPoint0_1,
                        basicPoint1_0,
                        BasicPoint.create(2)
                    )
                ),
                new Line(
                    Arrays.asList(
                        BasicPoint.create(0),
                        basicPoint1_2,
                        basicPoint2_1
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
    LinkablePoint basicPoint0_1 = BasicPoint.create(0);
    LinkablePoint basicPoint1_0 = basicPoint0_1.createNextWithLinkedBy(true);
    LinkablePoint basicPoint1_2 = BasicPoint.create(1);
    LinkablePoint basicPoint2_1 = basicPoint1_2.createNextWithLinkedBy(true);
//    Point point3 = point2.createNextWithLinkedBy(true);
//
    return Stream.of(
        arguments(
            new Ladder(Arrays.asList(
                new Line(
                    Arrays.asList(
                        BasicPoint.create(0),
                        BasicPoint.create(1)
                    )
                )
            ))
        ),
        arguments(
            new Ladder(Arrays.asList(
                new Line(
                    Arrays.asList(
                        basicPoint0_1,
                        basicPoint1_0,
                        BasicPoint.create(2)
                    )
                ),
                new Line(
                    Arrays.asList(
                        BasicPoint.create(0),
                        basicPoint1_2,
                        basicPoint2_1
                    )
                )
            ))
        )
    );
  }
}