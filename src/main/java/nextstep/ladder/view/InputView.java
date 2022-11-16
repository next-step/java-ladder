package nextstep.ladder.view;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import nextstep.ladder.domain.Height;
import nextstep.ladder.domain.Player;

public class InputView {
  private static final String PLAYER_NAME_DELIMITER = ",";
  private final InputSupplier inputSupplier;
  private final OutputConsumer outputConsumer;

  public InputView(InputSupplier inputSupplier, OutputConsumer outputConsumer) {
    this.inputSupplier = inputSupplier;
    this.outputConsumer = outputConsumer;
  }

  public List<Player> inputPlayers() {
    outputConsumer.write("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
    final String playerNames = inputSupplier.read();
    return Arrays.stream(playerNames.split(PLAYER_NAME_DELIMITER))
                 .map(String::trim)
                 .map(Player::new)
                 .collect(Collectors.toList());
  }

  public Height inputLadderHeight() {
    outputConsumer.write("최대 사다리 높이는 몇 개인가요?");
    final String ladderHeight = inputSupplier.read();
    return new Height(Integer.parseInt(ladderHeight));
  }
}
