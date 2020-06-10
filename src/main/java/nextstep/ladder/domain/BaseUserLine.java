package nextstep.ladder.domain;

public class BaseUserLine {
    private final static int USER_NAME_LENGTH_LIMIT = 5;

    private final String userName;
    private final ConnectPoints connectPoints;

    public BaseUserLine(final String userName, final ConnectPoints connectPoints) {
        validate(userName);
        this.userName = userName;
        this.connectPoints = connectPoints;
    }

    private void validate(final String userName) {
        int userNameSize = userName.length();
        if (userNameSize > USER_NAME_LENGTH_LIMIT) {
            throw new IllegalArgumentException(String.format("유저이름은 5자를 넘길 수 없습니다. 현재글자수: %d", userNameSize));
        }
    }

    public boolean isConnected(final Point point) {
        return connectPoints.hasPoint(point);
    }
}
