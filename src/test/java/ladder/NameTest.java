package ladder;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class NameTest {

  public static final List<Name> PLAYER_NAME_LIST_1 = Stream.of("a", "bb", "ccc", "dddd", "eeeee")
      .map(Name::new)
      .collect(Collectors.toUnmodifiableList());

  @ParameterizedTest(name = "{0}으로 Name 생성 성공")
  @ValueSource(strings = {"a", "bb", "ccc", "dddd", "eeeee"})
  void Name_생성_성공(String validName) {
    assertDoesNotThrow(() -> new Name(validName));
  }

  @DisplayName("all으로 캐싱 Name 생성 성공")
  @Test
  void Name_ALL_생성_성공() {
      assertThat(Name.ALL).isEqualTo(new Name("all"));
  }

  @DisplayName("exit으로 캐싱 Name 생성 성공")
  @Test
  void Name_EXIT_생성_성공() {
    assertThat(Name.EXIT).isEqualTo(new Name("exit"));
  }

  @Test
  void equals_성공() {
    assertThat(new Name("test")).isEqualTo(new Name("test"));
  }

  @ParameterizedTest(name = "{0}으로 Name 생성 실패")
  @ValueSource(strings = {"", " ", "123456"})
  void Name_생성_실패(String invalidName) {
    assertThrows(IllegalArgumentException.class, ()-> new Name(invalidName));
  }

  @ParameterizedTest(name = "{0}으로 toString 성공")
  @ValueSource(strings = {"a", "bb", "ccc", "dddd", "eeeee"})
  void toString_성공(String rawName) {
    Name name = new Name(rawName);
    assertThat(name.toString()).isEqualTo(rawName);
  }

  @Test
  void NAME_ALL_생성_성공() {
    assertThat(Name.of("all")).isEqualTo(Name.ALL);
  }

  @Test
  void NAME_EXIT_생성_성공() {
    assertThat(Name.of("exit")).isEqualTo(Name.EXIT);
  }
}
