package ladder.domain;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Users {

  private final Set<User> users;
  private static final String INVALID_DUPLICATED_NAME = "중복된 이름은 사용할 수 없습니다.";

  public Users(String[] names) {
    this.users = IntStream.range(0, names.length)
        .mapToObj(position -> new User(names[position],position))
        .collect(Collectors.toSet());
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
