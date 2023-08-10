package ladder.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Users {

  private final List<User> users;

  public Users(List<User> users) {
    this.users = users;
  }

  public static Users of(List<String> names) {
    return new Users(names.stream()
        .map(User::new)
        .collect(Collectors.toList()));
  }


  public int count() {
    return users.size();
  }

  public List<String> names() {
    return users.stream()
        .map(User::getName)
        .collect(Collectors.toList());
  }

  public List<User> getUsers() {
    return this.users;
  }
}
