package ladder.view.input;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import ladder.domain.prize.Prize;
import ladder.domain.prize.Prizes;

public class InputLadderResultView extends InputView {

  private static final String DELIMITER = ",";

  public static Prizes scanPrizes(int sizeOfParticipant) {
    System.out.println("사다리 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
    String prizes = SCANNER.nextLine();
    String[] splitPrizes = split(prizes);
    validateSize(splitPrizes, sizeOfParticipant);
    List<Prize> ladderPrizes =  toList(splitPrizes);
    return new Prizes(ladderPrizes);
  }

  private static List<Prize> toList(String[] splitLadderResult) {
    return Stream.of(splitLadderResult)
        .map(Prize::new)
        .collect(Collectors.toList());

  }
  private static void validateSize(String[] prizes, int sizeOfParticipant) {
    if (isNotSameSize(prizes, sizeOfParticipant)) {
      throw new IllegalArgumentException("참여자 수와 결과의 수가 다릅니다.");
    }
  }

  private static boolean isNotSameSize(String[] prizes, int sizeOfParticipant) {
    return prizes.length != sizeOfParticipant;
  }

  private static String[] split(String result) {
    return result.split(DELIMITER);
  }

}
