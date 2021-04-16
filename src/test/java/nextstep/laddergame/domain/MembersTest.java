package nextstep.laddergame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class MembersTest {
  @Test
  @DisplayName("이름 목록으로 Members 객체를 생성하면 목록 개수를 제공한다")
  public void create() throws Exception {
    //given
    String s = "pobi,honux,crong,jk";
    String[] split = s.split(",");

    //when
    Members members = Members.createMembers(split);

    //then
    assertEquals(members.size(), 4);
  }

  @ParameterizedTest
  @ValueSource(strings = {"a,a", "a,b,c,d,d"})
  @DisplayName("이름 목록을 중복으로 넣을 경우 Exception이 발생한다")
  public void createException(String userNames) throws Exception {
    //given
    String[] split = userNames.split(",");

    //when
    IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
        () -> Members.createMembers(split));

    //then
    assertTrue(thrown.getMessage().contains("ERROR"));
  }
}