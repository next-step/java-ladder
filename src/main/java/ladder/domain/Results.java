package ladder.domain;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import ladder.exception.ResultIndecisiveException;
import ladder.exception.UserNotFoundException;

public class Results {

  private final List<Prize> prizes;
  private final Map<User, Prize> userPrizeMap;

  public Results(List<String> prizes, List<User> users) {
    this.userPrizeMap = IntStream.range(0, prizes.size())
        .boxed()
        .collect(Collectors.toMap(
            users::get,
            integer -> new Prize(prizes.get(integer))
        ));
    this.prizes = prizes.stream()
        .map(Prize::new)
        .collect(Collectors.toList());
  }

  private static boolean isAll(String s) {
    return s.equals("all");
  }

  public List<String> getPrizes() {
    return userPrizeMap.values()
        .stream()
        .map(Prize::value)
        .collect(Collectors.toList());
  }

  public void confirmUserPrize(List<Integer> orders, List<User> users) {
    for (int i = 0; i < orders.size(); i++) {
      userPrizeMap.put(users.get(orders.get(i)), prizes.get(i));
    }
  }

  public List<String> findAllPrizesByUserOrAll(String s) {
    if (isAll(s)) {
      return findAll();
    }
    validate(s);
    return List.of(this.resultRendering(new User(s)));
  }

  private void validate(String s) {
    if (userPrizeMap.isEmpty()) {
      throw new ResultIndecisiveException();
    }
    userPrizeMap.computeIfAbsent(new User(s), (key) -> {
      throw new UserNotFoundException(key);
    });
  }

  private List<String> findAll() {
    return userPrizeMap.keySet().stream()
        .map(this::resultRendering)
        .collect(Collectors.toList());
  }

  private String resultRendering(User user) {
    return user.getName()
        .concat(" : ")
        .concat(userPrizeMap
            .get(user)
            .value());
  }
}
