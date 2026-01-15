package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class PersonTest {
  @ParameterizedTest
  @CsvSource({"abcde", "a"})
  void 이름은최대5글자(String name){
    assertDoesNotThrow(() -> new Person(name));
  }

  @Test
  void 이름5글자초과시예외(){
    assertThatThrownBy(() -> new Person("abcdef"))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("이름은 최대 5글자까지 부여할 수 있습니다.");
  }

}