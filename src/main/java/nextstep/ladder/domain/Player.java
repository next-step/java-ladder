package nextstep.ladder.domain;

public class Player {
  private final PlayerName playerName;

  // order로 정렬할 것이기 때문에 boxing에 대한 불필요한 리소스를 고려해서 Integer로 선언
  private final Integer order;
  private final String result;

  public Player(PlayerName playerName, Integer order, String result) {
    this.playerName = playerName;
    this.order = order;
    this.result = result;
  }

  public String getResult() {
    return this.result;
  }

  public PlayerName getPlayerName() {
    return this.playerName;
  }

  public Integer getOrder() {
    return this.order;
  }
}
