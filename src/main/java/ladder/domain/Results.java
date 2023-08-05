package ladder.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import ladder.exception.ResultIndecisiveException;
import ladder.exception.UserNotFoundException;

public class Results {

  private final Map<User, Prize> ratedUserPrizeMap;
  private final List<String> originalPrizes;

  public Results(List<String> prizes, List<User> users, Ladder ladder) {
    this.originalPrizes = prizes;
    this.ratedUserPrizeMap = mappingUserToPrizes(prizes, users, ladder);
  }

  private static Map<User, Prize> mappingUserToPrizes(
      List<String> prizes,
      List<User> users,
      Ladder ladder) {

    List<Integer> rating = LadderSolver.calculate(users.size(), ladder.allLines());
    Map<User, Prize> collect = new HashMap<>();
    for (int i = 0; i < users.size(); i++) {
      collect.put(users.get(i), new Prize(prizes.get(rating.get(i))));
    }
    return collect;
  }

  private static boolean isAll(String s) {
    return s.equals("all");
  }

  public List<String> getOriginalPrizes() {
    return originalPrizes;
  }

  public List<String> findAllPrizesByUserOrAll(String query) {
    if (isAll(query)) {
      return findAll();
    }
    validate(query);
    return List.of(this.resultRendering(new User(query)));
  }

  private void validate(String query) {
    if (ratedUserPrizeMap.isEmpty()) {
      throw new ResultIndecisiveException();
    }
    ratedUserPrizeMap.computeIfAbsent(new User(query), (key) -> {
      throw new UserNotFoundException(key);
    });
  }

  private List<String> findAll() {
    return ratedUserPrizeMap.keySet().stream()
        .map(this::resultRendering)
        .collect(Collectors.toList());
  }

  private String resultRendering(User user) {
    return user.getName()
        .concat(" : ")
        .concat(ratedUserPrizeMap
            .get(user)
            .value());
  }
}
