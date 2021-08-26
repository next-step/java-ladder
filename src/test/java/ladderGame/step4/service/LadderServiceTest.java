package ladderGame.step4.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import ladderGame.step4.dto.CreatorDto;
import ladderGame.step4.dto.ModelDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderServiceTest {

  @DisplayName("입력되는 사용자명, 사다리높이값, 경품내용을 주입받아 사용자, 사다리, 경품을 생성하여 dto로 반환되는지 확인한다.")
  @Test
  void create() {
    String playerNames = "user1,user2";
    String goods = "prz1,prz2";
    int ladderHeight = 2;

    LadderService ladderService = new LadderService();
    ModelDto modelDto = ladderService.create(new CreatorDto(playerNames, goods, ladderHeight));

    assertAll(
        () -> assertThat(modelDto.getPlayers().playersName()).contains("user1,user2"),
        () -> assertThat(modelDto.getLadder().ladderValues().size()).isEqualTo(2),
        () -> assertThat(modelDto.getPrizes().prizeNames()).contains("prz1,prz2")
    );
  }
}