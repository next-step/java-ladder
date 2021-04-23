package nextstep.laddergame;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import nextstep.laddergame.domain.Ladder;
import nextstep.laddergame.domain.Lines;
import nextstep.laddergame.domain.Members;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LadderTest {

  @Test
  @DisplayName("이름 목록과 높이를 통해서 Ladder를 생성한다")
  public void create() throws Exception {
    //given
    String s = "pobi,honux";
    String[] split = s.split(",");
    int height = 5;

    Members members = Members.createMembers(split);

    //when
    Ladder ladder = Ladder.createLadder(height, members);

    //then
    assertNotNull(ladder);
  }

  @Test
  @DisplayName("사람 이름을 전달하여 사다리 게임 결과 인덱스를 얻을 수 있다")
  public void find() throws Exception {
    //given
    String s = "pobi,honux";
    String[] split = s.split(",");
    int height = 5;

    Members members = Members.createMembers(split);
    Lines lines = testCreateLines(height, members);

    //when
    Ladder ladder = new Ladder(members, lines);

    //then
    assertAll(
        () -> assertEquals(ladder.find(members.names().get(0)), 1),
        () -> assertEquals(ladder.find(members.names().get(1)), 0)
    );
  }

  @ParameterizedTest
  @CsvSource({"'a,b,c', 3",
              "'a,b,c,d', 4",
              "'a,b,c,d,e', 5"})
  @DisplayName("findAll() 메소드를 통하여 중복 되지 않은 사다리 결과의 전체 인덱스를 얻을 수 있다")
  public void findAll(String s, int result) throws Exception {
    //given
    String[] split = s.split(",");
    int height = 5;

    Members members = Members.createMembers(split);
    Lines lines = testCreateLines(height, members);

    //when
    Ladder ladder = new Ladder(members, lines);

    //then
    assertEquals(Arrays.stream(ladder.findAll(members))
        .distinct()
        .count(), result);
  }

  private Lines testCreateLines(int height, Members members) {
    return new Lines(IntStream.range(0, height)
        .mapToObj(i -> new LineGenerator(members.size()).generate(() -> true))
        .collect(Collectors.toList()));
  }
}