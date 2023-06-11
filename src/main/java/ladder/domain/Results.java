package ladder.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Results {

  private final List<Prize> prizes;

  private final Map<User, Prize> userPrizeMap = new HashMap<>();

  public Results(List<String> prizes) {
    this.prizes = prizes.stream()
        .map(Prize::new)
        .collect(Collectors.toList());
  }

  private static boolean isAll(String s) {
    return s.equals("all");
  }

  public List<String> getPrizes() {
    return prizes.stream()
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
    if (Optional.ofNullable(userPrizeMap).isEmpty()) {
      throw new RuntimeException("not yet impl");
    }
    userPrizeMap.computeIfAbsent(new User(s), (key) -> {
      System.out.println(key.getName());
      throw new RuntimeException("not yet impl");
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
