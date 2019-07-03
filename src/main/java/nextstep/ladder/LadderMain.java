package nextstep.ladder;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LadderMain {
    public static void main(String[] args) {
        String[] userNames = Input.getUsers();
        List<User> users = Arrays.stream(userNames)
                .map(userName -> new User(userName))
                .collect(Collectors.toList());

        String[] resultValues = Input.getResults(userNames.length);
        List<String> results = Arrays.stream(resultValues).collect(Collectors.toList());

        int height = Input.getMaxHeight();

        Ladder ladder = new Ladder(height, users.size(), new RandomBooleanFunction());

        PrintResult.printUsers(users);
        PrintResult.println();
        PrintResult.printLadder(ladder);
    }
}
