package laddergame.model;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LadderResultMapperTest {

  LadderResultMapper resultMap;

  @BeforeEach
  void setUp() {
    resultMap = new LadderResultMapper(new LinkedHashMap<Name, Name>() {{
      put(new Name("key1"), new Name("val1"));
      put(new Name("key2"), new Name("val2"));
    }});
  }

  @ParameterizedTest
  @MethodSource("providePlayerName")
  void getResultOf(Name playerName, Name expected) {
    assertThat(resultMap.getResultOf(playerName)).isEqualTo(expected);
  }

  public static Stream<Arguments> providePlayerName() {
    return Stream.of(
        arguments(
            new Name("key1"),
            new Name("val1")
        )
    );
  }

  @ParameterizedTest
  @MethodSource("providePlayerNameNotExist")
  @DisplayName("존재하지 않는 경우")
  void getResultOf_NotExist(Name playerName) {
    assertThatExceptionOfType(PlayerNotExistException.class).isThrownBy(()->{
      resultMap.getResultOf(playerName);
    });
  }

  public static Stream<Arguments> providePlayerNameNotExist() {
    return Stream.of(
        arguments(
            new Name("key0")
        )
    );
  }

  @ParameterizedTest
  @MethodSource("provideLadderPlayersResults")
  void  createBy(Ladder ladder, PlayerNames players, ResultNames results, Map<Name, Name> expected) {
    LadderResultMapper resultMap = LadderResultMapper.createBy(ladder, players, results);
    System.out.println(resultMap);
    assertThat(resultMap.getEntrySet()).isEqualTo(expected.entrySet());
  }

  public static Stream<Arguments> provideLadderPlayersResults() {
    return Stream.of(
        arguments(
            new Ladder(Arrays.asList(
                new Line(Arrays.asList(
                    new Point(false),
                    new Point(true),
                    new Point(false)
                )),
                new Line(Arrays.asList(
                    new Point(false),
                    new Point(false),
                    new Point(true)
                ))
            )),
            new PlayerNames(
                Arrays.asList(
                    new Name("name1"),
                    new Name("name2"),
                    new Name("name3")
                )
            ),
            new ResultNames(
                Arrays.asList(
                    new Name("res1"),
                    new Name("res2"),
                    new Name("res3")
                )
            ),
            new LinkedHashMap<Name, Name>() {{
              put(new Name("name1"), new Name("res3"));
              put(new Name("name2"), new Name("res1"));
              put(new Name("name3"), new Name("res2"));
            }}
        )
    );
  }
}