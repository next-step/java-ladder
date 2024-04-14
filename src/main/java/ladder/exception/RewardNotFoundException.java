package ladder.exception;

import ladder.domain.participants.Position;

public class RewardNotFoundException extends RuntimeException {

    public RewardNotFoundException(Position position) {
        super("해당 위치에 실행 결과가 존재하지 않습니다 : " + position);
    }
}
