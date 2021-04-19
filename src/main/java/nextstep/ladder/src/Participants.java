package nextstep.ladder.src;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Participants {
  private static final int SPACE_SIZE = 6;
  private static final String SPACE = "";

  private final List<User> participants;

  public Participants(List<User> participants) {
    this.participants = participants;
  }

  public static Participants makeByString(String users) {
    assureNotEmpty(users);
    return new Participants(
      Arrays.stream(users.split(","))
        .map(String::trim)
        .map(User::new)
        .collect(Collectors.toList())
    );
  }

  private static void assureNotEmpty(String users) {
    if(users == null || users.equals("")) {
      throw new IllegalArgumentException("null or 빈값이 들어올 수 없습니다.");
    }
  }

  public int numberOfParticipants() {
    return participants.size();
  }

  public String names() {
    String users = participants.stream()
      .map(user -> String.format("%" + SPACE_SIZE + "s", user.name()))
      .collect(Collectors.joining(""));
    return SPACE + users;
  }

  public int maxNameLength() {
    return participants.stream()
      .map(user -> user.name().length())
      .reduce(0, (max, no) -> max < no ? no : max);
  }
}
