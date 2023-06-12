package ladder.domain;

import java.util.List;

public class Scene {

  private final List<String> ladderArea;
  private final String userArea;
  private final String resultArea;

  public Scene(List<String> ladderArea, String userArea, String resultArea) {
    this.ladderArea = ladderArea;
    this.userArea = userArea;
    this.resultArea = resultArea;
  }

  public List<String> getLadderArea() {
    return ladderArea;
  }

  public String userArea() {
    return userArea;
  }

  public String prizeArea() {
    return this.resultArea;
  }
}
