package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import ladder.domain.store.NameStore;
import ladder.domain.store.ResultStore;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ResultStoreTest {

  @Test
  @DisplayName("[ResultStore] 입력 받은 텍스트 Result 리스트로 반환하는 기능 테스트")
  void inputResultToListTest() {
    String inputNames = "crong,pobi,honux,jk";
    String inputResult = "꽝,5000,3000,꽝";
    int size = ResultStore.createResult(inputResult, new Players(NameStore.createPlayers(inputNames))).size();

    assertThat(size).isEqualTo(4);
  }

  @Test
  @DisplayName("[ResultStore] 결과와 참가자 수가 맞지 않는 경우 예외 처리 테스트")
  void validateResultLengthTest() {
    String inputNames = "crong,pobi,honux,jk";
    String inputResult = "꽝,5000,3000";

    assertThatThrownBy(() ->
        ResultStore.createResult(inputResult, new Players(NameStore.createPlayers(inputNames))))
        .isInstanceOf(IllegalArgumentException.class);
  }
}
