package ladder.exception;

import ladder.domain.User;

public class UserNotFoundException extends IllegalArgumentException {

  public UserNotFoundException(User user) {
    super("알수없는 User 정보가 입력되었습니다 : " + user.toString());
  }
}
