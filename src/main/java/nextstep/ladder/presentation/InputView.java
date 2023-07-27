package nextstep.ladder.presentation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import nextstep.ladder.domain.PlayerName;
import nextstep.ladder.domain.PlayerNames;
import nextstep.ladder.domain.dto.Rewards;

public class InputView {

  private final static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
  public static PlayerNames getPlayerNames() {
    System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");

    // split을 여기서 할까 PlayerNames에서 할까 고민하다가, 자르는 건 view의 책임이라 판단해 여기서 함
    return new PlayerNames(readLine().split(","));
  }

  public static int getLadderLength() {
    System.out.println("최대 사다리 높이는 몇 개인가요?");

    return Integer.parseInt(readLine());
  }

  public static Rewards getRewards() {
    System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");

    return new Rewards(readLine().split(","));
  }

  public static PlayerName getPlayerName() {
    System.out.println("결과를 보고 싶은 사람은?");

    String playerName = readLine();
    return new PlayerName(playerName);
  }

  private static String readLine() {
    try {
      return bufferedReader.readLine();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
