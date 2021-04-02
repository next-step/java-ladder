package ladder.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Users {

  private final Set<User> users;
  private static final String INVALID_DUPLICATED_NAME = "중복된 이름은 사용할 수 없습니다.";

  public Users(String[] names) {
    users = new LinkedHashSet<>();
    for (String name : names) {
      users.add(new User(name));
    }
    validateDuplicatedName(names.length);
  }

  private void validateDuplicatedName(int nameSize) {
    if (nameSize != users.size()) {
      throw new IllegalArgumentException(INVALID_DUPLICATED_NAME);
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Users users1 = (Users) o;
    return Objects.equals(users, users1.users);
  }

  @Override
  public int hashCode() {
    return Objects.hash(users);
  }

  public Set<User> getUsers() {
    return users;
  }
}
