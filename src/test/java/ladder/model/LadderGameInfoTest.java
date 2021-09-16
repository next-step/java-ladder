package ladder.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LadderGameInfoTest {

  @Test
  @DisplayName("생성 테스트")
  void createTest() {
    //given
    String participants = "pobi,honux,crong,jk";
    String results = "꽝,5000,꽝,3000";

    //when
    LadderGameInfo ladderGameInfo = new LadderGameInfo(participants, results);

    //then
    assertThat(ladderGameInfo.getParticipantCnt()).isEqualTo(4);
  }

  @ParameterizedTest(name = "잘못된 생성 테스트")
  @CsvSource(
      value = {"pobi,honux,crong,jk|꽝,5000,꽝", "pobi,pobi,crong,jk|꽝,5000,꽝,3000"},
      delimiter = '|'
  )
  void invalidCreateTest(String participants, String results) {
    assertThatIllegalArgumentException().isThrownBy(() -> {
      new LadderGameInfo(participants, results);
    });
  }
}