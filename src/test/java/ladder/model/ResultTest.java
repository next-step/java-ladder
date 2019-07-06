package ladder.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class ResultTest {

  private Result result;

  @BeforeEach
  void setUp() {
    result = new Result();
  }

  @Test
  @DisplayName("get 테스트")
  void get() {
    result.add("kim", "3000");

    assertThat(result.get("kim")).isEqualTo("3000");
  }

  @Test
  @DisplayName("해당하는 player가 없을때")
  void get_throw_exception() {
    assertThatThrownBy(() -> result.get("hoy"))
            .isInstanceOf(IllegalArgumentException.class);
  }
}
