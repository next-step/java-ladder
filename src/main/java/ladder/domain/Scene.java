package ladder.domain;

import java.util.List;

public class Scene {

  private final List<String> ladderArea;
  private final String userArea;

  public Scene(List<String> ladderArea, String userArea) {
    this.ladderArea = ladderArea;
    this.userArea = userArea;
  }

  public List<String> getLadderArea() {
    return ladderArea;
  }

  public String userArea() {
    return userArea;
  }
}
