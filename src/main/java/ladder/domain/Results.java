package ladder.domain;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Results {

  private final List<Prize> prizes;

  Map<User, Prize> userPrizeMap;

  public Results(List<String> prizes) {
    this.prizes = prizes.stream()
        .map(Prize::new)
        .collect(Collectors.toList());
  }

  public List<String> getPrizes() {
    return prizes.stream()
        .map(Prize::value)
        .collect(Collectors.toList());
  }

  public void confirmUserPrize(List<Integer> userOrder, Users users) {
    this.userPrizeMap = userOrder.stream().collect(Collectors.toMap(
            integer -> users.getUsers().get(integer),
            this.prizes::get
        )
    );
//    userPrizeMap = IntStream.range(0, users.size()).boxed()
//        .collect(Collectors.toMap(
//            users::get,
//            this.prizes::get
//        ));
  }

  public List<String> findAllPrizesByUserOrAll(String s) {
    validate(s);
    if (isAll(s)) {
      return findAll();
    }
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

  private static boolean isAll(String s) {
    return s.equals("all");
  }

  private String resultRendering(User user) {
    return user.getName()
        .concat(userPrizeMap
            .get(user)
            .value()
        );
  }
}
