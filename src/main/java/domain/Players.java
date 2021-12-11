package domain;

import common.Strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static common.Constants.DELIMITER;
import static common.ErrorMessages.NAME_IS_EMPTY;
import static java.util.stream.Collectors.toList;

public class Players {

  private List<Player> players = new ArrayList<>();

  public Players(String names) {
    checkNames(names);
    makePlayers(names);
  }

  private void checkNames(String names) {
    if (Strings.isBlank(names)) {
      throw new IllegalArgumentException(NAME_IS_EMPTY);
    }
  }

  private void makePlayers(String names) {
    List<String> nameList = Arrays.asList(names.trim().split(DELIMITER));
    checkEmpty(nameList);
    players = nameList.stream()
            .map(name -> new Player(name))
            .collect(toList());
  }

  private void checkEmpty(List<String> nameList) {
    if (nameList.isEmpty()) {
      throw new RuntimeException(NAME_IS_EMPTY);
    }
  }

  public List<Player> getPlayers() {
    return new ArrayList(players);
  }


}
