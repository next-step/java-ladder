package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Users {

  private final List<User> users;

  public Users(List<User> users){
    this.users = users;
  }

  public Users(String[] names) {
    users = new ArrayList<>();
    for (String name : names) {
      users.add(new User(name));
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

  public List<User> getUsers() {
    return users;
  }
}
