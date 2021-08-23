package ladderGame.step4.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;

class MatchResultTest {

  @DisplayName("검색사용자에 대한 사다리 결과 인덱스 반환 생성 검증.")
  @Test
  void crateMatchResultTest() {

    MatchResult origin = MatchResult.createMatchResult("user1", 1);
    MatchResult sameOne = MatchResult.createMatchResult("user1", 1);
    assertThat(origin).isEqualTo(sameOne);
  }

  @ParameterizedTest
  @CsvSource(value = {"user1"})
  @NullSource
  @EmptySource
  void invalidNameAndIndex(String name) {
    assertThatThrownBy(() -> MatchResult.createMatchResult(name, -1))
        .isInstanceOf(IllegalArgumentException.class);
  }
}