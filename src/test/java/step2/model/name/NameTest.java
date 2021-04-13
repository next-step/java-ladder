package step2.model.name;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import step2.error.InvalidNameException;

import static org.assertj.core.api.Assertions.*;

class NameTest {
  @ParameterizedTest
  @ValueSource(strings = {"boltas", "xtxtxtxtxxtxtxtx"})
  @DisplayName("이름 제한 크기 벗어나 생성 실패")
  void invalidNameTest(String name){
    assertThatThrownBy(()-> new Name(name)).isInstanceOf(InvalidNameException.class).hasMessage("잘못된 이름입니다.");
  }

  @ParameterizedTest
  @ValueSource(strings = {"   asdf   ", "fdsf  "})
  @DisplayName("빈 칸 많아도 글자 내에 있으면 생성 가능")
  void validNameWithSpaceTest(String name){

    Name targetName = new Name(name.trim());

    assertThat(new Name(name)).isEqualTo(targetName);
  }

  @ParameterizedTest
  @ValueSource(strings = {"var", "char"})
  @DisplayName("정상적인 글자 생성 가능")
  void validNameTest(String name){

    Name targetName = new Name(name.trim());

    assertThat(new Name(name)).isEqualTo(targetName);
  }
}