package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Users {

  List<User> users;

  public Users(List<String> names) {
    users = new ArrayList<>();
    for (int i = 0; i< names.size(); i++) {
      users.add(new User(names.get(i)));
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
}
