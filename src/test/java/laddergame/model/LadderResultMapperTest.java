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
    resultMap = new LadderResultMapper(new LinkedHashMap<PlayerName, ResultName>() {{
      put(PlayerName.createBy("key1"), ResultName.createBy("val1"));
      put(PlayerName.createBy("key2"), ResultName.createBy("val2"));
    }});
  }

  @ParameterizedTest
  @MethodSource("providePlayerName")
  void getResultOf(PlayerName playerName, ResultName expected) {
    assertThat(resultMap.getResultOf(playerName)).isEqualTo(expected);
  }

  public static Stream<Arguments> providePlayerName() {
    return Stream.of(
        arguments(
            PlayerName.createBy("key1"),
            ResultName.createBy("val1")
        )
    );
  }

  @ParameterizedTest
  @MethodSource("providePlayerNameNotExist")
  @DisplayName("존재하지 않는 경우")
  void getResultOf_NotExist(PlayerName playerName) {
    assertThatExceptionOfType(PlayerNotExistException.class).isThrownBy(() -> {
      resultMap.getResultOf(playerName);
    });
  }

  public static Stream<Arguments> providePlayerNameNotExist() {
    return Stream.of(
        arguments(
            PlayerName.createBy("key0")
        )
    );
  }

  @ParameterizedTest
  @MethodSource("provideLadderPlayersResults")
  void createBy(Ladder ladder, PlayerNames players, ResultNames results, Map<PlayerNames, ResultNames> expected) {
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
                    PlayerName.createBy("name1"),
                    PlayerName.createBy("name2"),
                    PlayerName.createBy("name3")
                )
            ),
            new ResultNames(
                Arrays.asList(
                    ResultName.createBy("res1"),
                    ResultName.createBy("res2"),
                    ResultName.createBy("res3")
                )
            ),
            new LinkedHashMap<PlayerName, ResultName>() {{
              put(PlayerName.createBy("name1"), ResultName.createBy("res3"));
              put(PlayerName.createBy("name2"), ResultName.createBy("res1"));
              put(PlayerName.createBy("name3"), ResultName.createBy("res2"));
            }}
        )
    );
  }
}