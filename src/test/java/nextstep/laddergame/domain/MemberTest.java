package nextstep.laddergame.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class MemberTest {
  @Test
  @DisplayName("이름을 입력받아서 Member를 생성한다")
  public void create() throws Exception {
    //given
    Member member = new Member("abcd");

    //when
    //then
    assertNotNull(member);
  }

  @ParameterizedTest
  @ValueSource(strings = {"", " ", "        "})
  @DisplayName("허용되지 않은 이름이 입력되면 Exception이 발생한다")
  public void createException(String value) throws Exception {
    //given
    //when
    IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
        () -> new Member(value));
    //then
    assertTrue(thrown.getMessage().contains("ERROR"));
  }
}