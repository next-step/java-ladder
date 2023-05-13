package ladder.view.input;

import java.util.List;
import java.util.stream.Collectors;
import ladder.domain.LaddersResult;
import ladder.domain.ParticipantSize;

public class InputLadderResultView extends InputView {

  private static final String DELIMITER = ",";

  public static LaddersResult scanLadderResult(ParticipantSize sizeOfParticipant) {
    System.out.println("사다리 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
    String result = SCANNER.nextLine();
    String[] splitLadderResult = split(result);
    validateSize(splitLadderResult, sizeOfParticipant);
    List<String> laddersResult =  toList(splitLadderResult);
    return new LaddersResult(laddersResult);
  }

  private static List<String> toList(String[] splitLadderResult) {
    return List.of(splitLadderResult);
  }
  private static void validateSize(String[] laddersResult, ParticipantSize sizeOfParticipant) {
    if (isNotSameSize(laddersResult, sizeOfParticipant)) {
      throw new IllegalArgumentException("참여자 수와 결과의 수가 다릅니다.");
    }
  }

  private static boolean isNotSameSize(String[] laddersResult, ParticipantSize sizeOfParticipant) {
    return laddersResult.length != sizeOfParticipant.size();
  }

  private static String[] split(String result) {
    return result.split(DELIMITER);
  }

}
