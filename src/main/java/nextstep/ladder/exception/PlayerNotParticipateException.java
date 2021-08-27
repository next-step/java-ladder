package nextstep.ladder.exception;

public class PlayerNotParticipateException extends IllegalArgumentException {

    public PlayerNotParticipateException() {
        super("게임에 참여하지 않은 플레이어가 있을때는 결과를 구할 수 없습니다.");
    }
}
