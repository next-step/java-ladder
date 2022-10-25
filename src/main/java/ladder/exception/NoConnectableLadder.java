package ladder.exception;

public class NoConnectableLadder extends LadderException {
    public NoConnectableLadder() {
        super("연결 가능한 사다리가 존재하지 않습니다.");
    }
}
