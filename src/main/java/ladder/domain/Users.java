package ladder.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Stream;

public class Users {

  private final List<User> users;
  private static final String INVALID_DUPLICATED_NAME = "중복된 이름은 사용할 수 없습니다.";

  public Users(String[] names) {
    validateDuplicatedName(names);
    this.users = new ArrayList<>();
    for (int i = 0; i < names.length; i++) {
      users.add(new User(names[i]));
    }

  }

  private void validateDuplicatedName(String[] names) {
    Set<String> hs = new HashSet(Arrays.asList(names));
    if (hs.size() != names.length) {
      throw new IllegalArgumentException(INVALID_DUPLICATED_NAME);
    }
  }

  public Stream<User> getUsers() {
    return users.stream();
  }

  public int numberOfUsers() {
    return users.size();
  }

  public User findUserByIndex(int index) {
    return users.get(index);
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

}
