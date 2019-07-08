package ladder.util;

import ladder.model.Players;

import java.util.Arrays;
import java.util.List;

public class MockPlayersGenerator {

  public static Players of(String... args) {
    List<String> names = Arrays.asList(args);
    return Players.of(names);
  }
}
