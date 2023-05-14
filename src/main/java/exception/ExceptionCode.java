package exception;

public enum ExceptionCode {

  // game
  MIN_LADDER_HEIGHT_REQUIRED("사다리 게임에 필요한 최소높이를 충족시키지 못합니다."),
  MIN_PLAYER_COUNT_REQUIRED("사다리 게임에 필요한 인원수보다 작습니다."),

  // ladder
  CANNOT_CONNECT_CONTINUOUS_POINT("사다리의 라인에서 포인트를 연속해서 연결 할 수 없습니다."),
  CANNOT_CONNECT_POINT_IN_REVERSE_ORDER("사다리는 왼쪽에서 오른쪽으로만 연결 할 수 있습니다."),
  LINE_POINT_NOT_FOUND("해당 사다리 라인에서 라인 포인트를 찾을 수 없습니다."),

  CONNECTION_CHECKED_NOT_SUPPORTED("사다리 라인에서 이어져있는지에 대한 체크는 인접한 포인트끼리만 가능합니다."),

  // player
  DUPLICATE_PLAYER_IN_GAME("중복된 플레이어가 존재합니다. 플레이어 목록을 확인하세요"),
  EXCEED_PLAYER_NAME_LENGTH("사다리게임 플레이어 최대 허용 이름 길이를 초과하였습니다.");

  private final String defaultMessage;

  ExceptionCode(String defaultMessage) {
    this.defaultMessage = defaultMessage;
  }

  public String getDefaultMessage() {
    return defaultMessage;
  }
}
