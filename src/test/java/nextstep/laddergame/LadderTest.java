package nextstep.laddergame;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import nextstep.laddergame.domain.Ladder;
import nextstep.laddergame.domain.Members;
import org.junit.jupiter.api.Test;

class LadderTest {

  @Test
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
}