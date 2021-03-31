package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NameStoreTest {
  @Test
  @DisplayName("[NameStore] 입력 받은 텍스트 Name 리스트로 반환하는 기능 테스트")
  void inputNamesToListTest() {
    String inputNames = "pobi,crong,honux";
    int size = NameStore.createPlayers(inputNames).size();

    assertThat(size).isEqualTo(3);
  }
}
