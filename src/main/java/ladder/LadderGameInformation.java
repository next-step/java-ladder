package ladder;

public class LadderGameInformation {

  private final Players players;
  private final int ladderHeight;
  private final LadderResult ladderResult;

  public LadderGameInformation(Players players, int ladderHeight, LadderResult ladderResult) {
    this.players = players;
    this.ladderHeight = ladderHeight;
    this.ladderResult = ladderResult;
    isPlayersCountLadderResultSame();
  }

  private void isPlayersCountLadderResultSame() {
    if (!ladderResult.isSamePlayerCount(players.count())) {
      throw new IllegalArgumentException("참여할 사람수와 실행결과 수는 같아야 합니다.");
    }
  }

  public int playersCount() {
    return players.count();
  }

  public int ladderHeight() {
    return ladderHeight;
  }

  public String getLengthFormatPlayersName() {
    return players.toString();
  }

  public String getLadderResult() {
    return ladderResult.toString();
  }

}
