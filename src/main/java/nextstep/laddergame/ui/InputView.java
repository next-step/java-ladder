package nextstep.laddergame.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import nextstep.laddergame.domain.Award;
import nextstep.laddergame.domain.Members;
import nextstep.laddergame.domain.Name;

public class InputView {

  private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

  public Members enteredUserNames() throws IOException {
    System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
    return Members.createMembers(reader.readLine()
        .split(","));
  }

  public int enteredLadderHeight() throws IOException {
    System.out.println("최대 사다리 높이는 몇 개인가요?");
    return Integer.parseInt(reader.readLine());
  }

  public Award enteredAward(int size) throws IOException {
    System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
    return Award.createPrizes(reader.readLine()
        .split(","), size);
  }

  public Name enteredFindResult() throws IOException {
    System.out.println("결과를 보고 싶은 사람은?");
    return new Name(reader.readLine());
  }
}
