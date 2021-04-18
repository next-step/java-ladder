package nextstep.ladder.src;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Participants {
  private final List<User> participants;

  public Participants(List<User> participants) {
    this.participants = participants;
  }

  public static Participants makeByString(String str) {
    assureNotEmpty(str);
    return new Participants(
      Arrays.stream(str.split(","))
      .map(String::trim)
      .map(User::new)
      .collect(Collectors.toList())
    );
  }

  private static void assureNotEmpty(String str) {
    if(str == null || str.equals("")) {
      throw new IllegalArgumentException("null or 빈값이 들어올 수 없습니다.");
    }
  }
}
