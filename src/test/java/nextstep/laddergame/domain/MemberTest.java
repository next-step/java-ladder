package nextstep.laddergame.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MemberTest {
  @Test
  @DisplayName("Member가 제대로 생성되는가")
  public void create() throws Exception {
    //given
    Member member = new Member("abcd");

    //when
    //then
    assertNotNull(member);
  }
}