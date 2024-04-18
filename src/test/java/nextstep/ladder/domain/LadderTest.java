package nextstep.ladder.domain;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LadderTest {

  @Test
  @DisplayName("사다리를 만들어, 사다리를 타고 움직일 때 정상적으로 이동하는지 확인")
  void move() {
    People people = makePeople();
    LadderMap ladderMap = makeLadderMap();
    Ladder ladder = new Ladder(people, ladderMap);
    LadderPrize prize = new LadderPrize(List.of("꽝", "5000", "2000", "3000"));

    Map<Person, String> result = ladder.getGameResult(prize).getResultByName(new Person("all"));

    assertThat(result.get(new Person("pobi"))).isEqualTo("2000");
    assertThat(result.get(new Person("crong"))).isEqualTo("5000");
    assertThat(result.get(new Person("honux"))).isEqualTo("3000");
    assertThat(result.get(new Person("lemon"))).isEqualTo("꽝");
  }

  private People makePeople() {
    return new People(
        List.of(new Person("pobi"), new Person("crong"), new Person("honux" ),  new Person("lemon")) );
  }

  private LadderMap makeLadderMap() {
    Line first = new Line(List.of(Point.of(TRUE), Point.of(FALSE), Point.of(TRUE)));
    Line second = new Line(List.of(Point.of(FALSE), Point.of(TRUE), Point.of(FALSE)));
    Line third = new Line(List.of(Point.of(TRUE), Point.of(FALSE), Point.of(FALSE)));
    return new LadderMap(List.of(first, second, third));
  }



}
