package nextstep.laddergame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class MembersTest {
  @Test
  @DisplayName("여러개의 이름을 입력받은 다음에 Members를 생성할 수 있는가")
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
  @ValueSource(strings = {"", "a,a"})
  @DisplayName("허용되지 않은 값이 입력될 경우 Exception이 발생하는가")
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