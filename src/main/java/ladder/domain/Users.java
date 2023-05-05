package ladder.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Users {

  private static final String USERS_DELIMITER = ",";
  private final List<User> users;

  private Users(List<User> users) {
    this.users = users;
  }

  public List<User> unmodifiableUsers() {

    return Collections.unmodifiableList(users);
  }

  public int countOfUser() {
    return users.size();
  }

  public static Users createUsers(String inputUsers) {
    return new Users(Arrays.stream(inputUsers.split(USERS_DELIMITER))
            .map(User::new)
            .collect(Collectors.toList()));
  }
}
