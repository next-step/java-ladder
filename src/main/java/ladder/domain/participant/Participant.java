package ladder.domain.participant;

import ladder.exception.InValidUserNameException;
import ladder.util.StringUtility;

import java.util.Objects;

public class Participant {

    private static final int USERNAME_LENGTH = 5;
    private final String userName;

    public Participant(String userName) {
        validateUserName(userName);
        this.userName = userName;
    }

    private void validateUserName(String userName) {
        if (StringUtility.isBlank(userName) || userName.length() > USERNAME_LENGTH) {
            throw new InValidUserNameException(userName);
        }
    }

    public String getUserName() {
        return userName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Participant that = (Participant) o;
        return Objects.equals(userName, that.userName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName);
    }

}
