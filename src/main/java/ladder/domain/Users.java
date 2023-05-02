package ladder.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Users {

  private static final String USERS_DELIMITER = ",";
  private final List<User> users;

  public Users(String inputUsers) {
    users = splitUsers(inputUsers);
  }

  public List<User> unmodifiableUsers() {

    return Collections.unmodifiableList(users);
  }

  public int countOfUser() {
    return users.size();
  }

  private List<User> splitUsers(String inputUsers) {
    return Arrays.stream(inputUsers.split(USERS_DELIMITER))
            .map(User::new)
            .collect(Collectors.toList());
  }
}
