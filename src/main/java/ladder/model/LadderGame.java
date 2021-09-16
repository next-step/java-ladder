package ladder.model;

import java.util.List;

public class LadderGame {

  private final LadderGameInfo ladderGameInfo;
  private final Ladder ladder;

  public LadderGame(LadderGameInfo ladderGameInfo, int height) {
    this(ladderGameInfo, new Ladder(height, ladderGameInfo.getParticipantCnt()));
  }

  public LadderGame(LadderGameInfo ladderGameInfo, Ladder ladder) {
    validateLadderGameInfoAndLadder(ladderGameInfo, ladder);
    this.ladderGameInfo = ladderGameInfo;
    this.ladder = ladder;
  }

  public boolean isExistFoothold(int heightIdx, int widthIdx) {
    return ladder.isExistFoothold(heightIdx, widthIdx);
  }

  public List<String> getParticipants() {
    return ladderGameInfo.getParticipants();
  }

  public List<String> getResults() {
    return ladderGameInfo.getResults();
  }

  public int getLadderHeight() {
    return ladder.getHeight();
  }

  public int getLadderWidth() {
    return ladder.getWidth();
  }

  private void validateLadderGameInfoAndLadder(LadderGameInfo ladderGameInfo, Ladder ladder) {
    if (ladderGameInfo.getParticipantCnt() != ladder.getWidth()) {
      throw new IllegalArgumentException("참여인원과 사다리크기가 일치하지 않습니다.");
    }
  }
}
