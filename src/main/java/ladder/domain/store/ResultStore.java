package ladder.domain.store;

import java.util.List;
import java.util.stream.Collectors;
import ladder.domain.Players;
import ladder.domain.Result;

public class ResultStore extends StringStore {

  public static List<Result> createResult(String inputResults, Players players) {
    validateInputText(inputResults);

    List<String> results = stringToList(inputResults);
    validateResultLength(players.names().size(), results.size());

    return results.stream()
        .map(Result::new)
        .collect(Collectors.toList());
  }

  private static void validateResultLength(int countOfPerson, int countOfResult) {
    if (countOfPerson != countOfResult) {
      throw new IllegalArgumentException("참가자와 입력 결과 수가 일치하지 않습니다.");
    }
  }
}
