package domain;

import common.ErrorMessages;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static common.Constants.MAX_PLAYER_NAME_LENGTH;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PlayerTest {

  @Test
  @DisplayName("이름이 Empty인경우 객체가 생성되지 않고 예외를 발생시키는지 검증하기 위한 테스트")
  void playerNameCanNotBeEmpty() {
    // given
    String wrongName = "";
    assertThatThrownBy(() ->
            new Player(wrongName)
    // then
    ).isInstanceOf(IllegalArgumentException.class)
            .withFailMessage(ErrorMessages.NAME_IS_EMPTY);
  }

  @Test
  @DisplayName("이름이 null인경우 객체가 생성되지 않고 예외를 발생시키는지 검증하기 위한 테스트")
  void playerNameCanNotBeNull() {
    // given
    String wrongName = null;
    assertThatThrownBy(() ->
            new Player(wrongName)
    // then
    ).isInstanceOf(IllegalArgumentException.class)
            .withFailMessage(ErrorMessages.NAME_IS_EMPTY);
  }

  @Test
  @DisplayName("이름이 제한글자를 초과한 경우 예외를 발생시키는지 검증하기 위한 테스트")
  void playerNameLengthCanNotBiggerThan_MAX_() {
    // given
    StringBuilder stringBuilder = new StringBuilder();
    for (int i = 0; i < MAX_PLAYER_NAME_LENGTH + 1; i++) {
      stringBuilder.append(i);
    }
    String wrongName = stringBuilder.toString();

    assertThatThrownBy(() ->
            // when
            new Player(wrongName)
    // then
    ).isInstanceOf(IllegalArgumentException.class)
            .withFailMessage(ErrorMessages.NAME_IS_TOO_LONG);
  }

}
