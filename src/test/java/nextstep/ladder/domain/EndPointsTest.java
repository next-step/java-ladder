package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class EndPointsTest {

  @DisplayName("정적 팩터리 메서드로 EndPoints를 생성한다.")
  @Test
  void createByFactoryMethod() {
    int playerSize = 4;
    List<String> values = List.of("꽝", "5000", "꽝", "3000");

    EndPoints endPoints = EndPoints.of(values, playerSize);

    assertThat(endPoints).isNotNull().isInstanceOf(EndPoints.class);
  }

  @DisplayName("playerSize와 입력값 리스트의 사이즈가 일치하지 않으면 예외를 던진다.")
  @Test
  void createWithValidation() {
    int playerSize = 5;
    List<String> values = List.of("꽝", "5000", "꽝", "3000");

    assertThatThrownBy(() -> EndPoints.of(values, playerSize))
        .isInstanceOf(IllegalArgumentException.class);
  }

  @DisplayName("index에 해당하는 값을 얻는다.")
  @Test
  void valueByIndex() {
    EndPoints endPoints = EndPoints.of(List.of("꽝", "5000", "꽝", "3000"), 4);

    assertAll(
        () -> assertThat(endPoints.valueByIndex(0)).isEqualTo("꽝"),
        () -> assertThat(endPoints.valueByIndex(1)).isEqualTo("5000"),
        () -> assertThat(endPoints.valueByIndex(2)).isEqualTo("꽝"),
        () -> assertThat(endPoints.valueByIndex(3)).isEqualTo("3000")
    );
  }
}
