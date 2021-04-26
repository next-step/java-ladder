package nextstep.laddergame.domain;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import nextstep.laddergame.LineGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LadderBoardTest {

  public Ladder ladder;
  public Award award;

  @BeforeEach
  void setUp() {
    Members members = testCreateMembers();
    award = testCreateAward(members.size());
    Lines lines = testCreateLines(5, members);
    ladder = new Ladder(members, lines);
  }

  @Test
  @DisplayName("Ladder와 Award를 인자로 받아서 생성한다")
  public void create() throws Exception {
    //given
    //when
    LadderBoard ladderBoard = new LadderBoard(ladder, award);

    //then
    assertNotNull(ladderBoard);
  }

  @ParameterizedTest
  @CsvSource({"pobi, 5000",
              "honux, 꽝",
              "crong, 10000",
              "jk, 꽝"})
  @DisplayName("이름을 전달받아서 해당 참여자의 사다리 결과 값을 찾는다")
  public void findOne(String name, String actualResult) throws Exception {
    //given
    LadderBoard ladderBoard = new LadderBoard(ladder, award);

    //when
    String expectedResult = ladderBoard.findOne(new Name(name));

    //then
    assertEquals(expectedResult, actualResult);
  }

  @Test
  @DisplayName("전체 결과를 Map의 형태로 얻을 수 있다")
  public void findAll() throws Exception {
    //given
    LadderBoard ladderBoard = new LadderBoard(ladder, award);

    //when
    Map<Name, Name> result = ladderBoard.findAll();

    assertAll(
        () -> assertEquals(result.get(new Name("pobi")).name(), "5000"),
        () -> assertEquals(result.get(new Name("honux")).name(), "꽝"),
        () -> assertEquals(result.get(new Name("crong")).name(), "10000"),
        () -> assertEquals(result.get(new Name("jk")).name(), "꽝")
    );
  }



  private Members testCreateMembers() {
    String s = "pobi,honux,crong,jk";
    String[] split = s.split(",");

    return Members.createMembers(split);
  }

  private Award testCreateAward(int countOfMembers) {
    String s = "꽝,5000,꽝,10000";
    String[] split = s.split(",");

    return Award.createPrizes(split, countOfMembers);
  }

  private Lines testCreateLines(int height, Members members) {
    return new Lines(IntStream.range(0, height)
        .mapToObj(i -> new LineGenerator(members.size()).generate(() -> true))
        .collect(Collectors.toList()));
  }

}