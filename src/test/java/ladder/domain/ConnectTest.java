package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.security.InvalidParameterException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class ConnectTest {

  @ParameterizedTest
  @DisplayName("왼쪽, 오른쪽 연결 여부에 따라 잘 생성되는지 확인")
  @CsvSource(value = {"true|false|LEFT", "false|true|RIGHT", "false|false|NONE"}, delimiter = '|')
  void of(boolean left, boolean right, Connect expect) {
    Connect connect = Connect.of(left, right);
    assertThat(connect).isEqualTo(expect);
  }

  @ParameterizedTest
  @DisplayName("첫번째 연결 여부 잘 생성되는지 확인")
  @CsvSource(value = {"false|NONE", "true|RIGHT"}, delimiter = '|')
  void first(boolean right, Connect expect) {
    Connect connect = Connect.first(right);
    assertThat(connect).isEqualTo(expect);
  }

  @ParameterizedTest
  @DisplayName("마지막 연결 여부 잘 생성되는지 확인")
  @CsvSource(value = {"false|NONE", "true|LEFT"}, delimiter = '|')
  void last(boolean prevRight, Connect expect) {
    Connect last = Connect.first(prevRight).last();
    assertThat(last).isEqualTo(expect);
  }

  @Test
  @DisplayName("왼쪽, 오른쪽 모두 연결되어 있을 경우 에러")
  void exception() {
    assertThatThrownBy(() -> Connect.of(true, true))
        .isInstanceOf(InvalidParameterException.class);
  }

  @ParameterizedTest
  @DisplayName("연결 방향에 따라 다음 인덱스 잘 가져오는지 확인")
  @CsvSource(value = {"LEFT|-1", "RIGHT|1", "NONE|0"}, delimiter = '|')
  void nextIndex(Connect connect, int moveAmount) {
    int expect = 1 + moveAmount;
    assertThat(connect.move(1)).isEqualTo(expect);
  }

  @ParameterizedTest
  @DisplayName("다음 연결을 현재 연결 여부에 따라 잘 생성하는지 확인")
  @CsvSource(value = {"LEFT|false|NONE", "LEFT|true|RIGHT", "RIGHT|false|LEFT", "NONE|true|RIGHT",
      "NONE|false|NONE"}, delimiter = '|')
  void generateNext(Connect connect, boolean nextConn, Connect expected) {
    assertThat(connect.generateNext(nextConn)).isEqualTo(expected);
  }
}