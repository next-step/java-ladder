package nextstep.ladder;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LadderMain {
    public static void main(String[] args) {
        String inputUserNames = Input.getUsers();

        String[] userNames = StringUtil.splitBySeparator(",", inputUserNames);
        List<User> users = Arrays.stream(userNames)
                .map(userName -> new User(userName))
                .collect(Collectors.toList());


        int height = Input.getMaxHeight();


    }
}
