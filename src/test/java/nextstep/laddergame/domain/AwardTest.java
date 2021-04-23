package nextstep.laddergame.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AwardTest {
  @Test
  @DisplayName("당첨 결과 목록으로 Award 객체를 생성하면 목록 개수를 제공한다")
  public void create() throws Exception {
    //given
    String s = "꽝,5000,꽝";
    String[] split = s.split(",");

    //when
    Award prizes = Award.createPrizes(split, 3);

    //then
    assertEquals(prizes.size(), 3);
  }

  @Test
  @DisplayName("멤버 인원 수와 당첨 목록의 개수가 다를 경우 익셉션이 발생한다")
  public void createThrown() throws Exception {
    //given
    String s = "꽝,5000,꽝";
    String[] split = s.split(",");

    //when
    IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
        () -> Award.createPrizes(split, 5));

    //then
    assertTrue(thrown.getMessage().contains("ERROR"));
  }
}