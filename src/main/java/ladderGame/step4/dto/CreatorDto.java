package ladderGame.step4.dto;

public class CreatorDto {

  private final String playerNames;
  private final String goods;
  private final int ladderHeight;

  public CreatorDto(final String playerNames, final String goods,
      final int ladderHeight) {
    this.playerNames = playerNames;
    this.goods = goods;
    this.ladderHeight = ladderHeight;
  }

  public String getPlayerNames() {
    return playerNames;
  }

  public String getGoods() {
    return goods;
  }

  public int getLadderHeight() {
    return ladderHeight;
  }
}