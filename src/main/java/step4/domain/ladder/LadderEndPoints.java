package step4.domain.ladder;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import step4.domain.user.Users;
import step4.exception.ladder.LadderEndPointCountException;
import step4.util.StringUtil;

public class LadderEndPoints {

    private final List<String> endPoints;

    private LadderEndPoints(List<String> endPoints) {
        this.endPoints = endPoints;
    }

    public static LadderEndPoints from(String input, Users users) {
        checkUsersCount(input, users);

        return new LadderEndPoints(Arrays.stream(StringUtil.splitByComma(input))
            .collect(Collectors.toList()));
    }

    private static void checkUsersCount(String input, Users users) {
        if (StringUtil.splitByComma(input).length != users.usersCount()) {
            throw new LadderEndPointCountException();
        }
    }

    public String endPointByPosition(int position) {
        return endPoints.get(position);
    }

}
