package exception;

public enum ExceptionCode {

  // player
  DUPLICATE_PLAYER_IN_GAME("중복된 플레이어가 존재합니다. 플레이어 목록을 확인하세요"),
  EXCEED_PLAYER_NAME_LENGTH("사다리게임 플레이어 최대 허용 이름 길이를 초과하였습니다.")

  ;



  private final String defaultMessage;

  ExceptionCode(String defaultMessage) {
    this.defaultMessage = defaultMessage;
  }

  public String getDefaultMessage() {
    return defaultMessage;
  }
}
