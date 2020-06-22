package laddergame.model;

public class PlayerNotExistException extends RuntimeException{
  private final static String playerNotExistExceptionMsg = "없는 사용자 입니다.";
  public PlayerNotExistException() {
    super(playerNotExistExceptionMsg);
  }

  public PlayerNotExistException(String msg){
    super(playerNotExistExceptionMsg + msg);
  }
}
