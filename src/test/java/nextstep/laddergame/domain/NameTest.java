package nextstep.laddergame.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class NameTest {
  @Test
  @DisplayName("이름을 입력받아서 Member를 생성한다")
  public void create() throws Exception {
    //given
    Name name = new Name("abcd");

    //when
    //then
    assertNotNull(name);
  }

  @ParameterizedTest
  @ValueSource(strings = {"", " ", "        "})
  @DisplayName("허용되지 않은 이름이 입력되면 Exception이 발생한다")
  public void createException(String value) throws Exception {
    //given
    //when
    IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
        () -> new Name(value));
    //then
    assertTrue(thrown.getMessage().contains("ERROR"));
  }
}