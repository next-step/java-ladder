package nextstep.ladder.domain.result;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class UserResults{
    List<UserResult> userResults;

    private UserResults(List<UserResult> userResults) {
        this.userResults = userResults;
    }

    public static UserResults of(UserResult ... userResults){
        return new UserResults(
            Arrays.stream(userResults)
                .collect(Collectors.toList())
        );
    }

    public static UserResults of(List<UserResult> userResults){
        return new UserResults(userResults);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UserResults that = (UserResults) o;
        return Objects.equals(userResults, that.userResults);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userResults);
    }

    @Override
    public String toString() {
        return "UserResults{" +
            "userResults=" + userResults +
            '}';
    }
}
