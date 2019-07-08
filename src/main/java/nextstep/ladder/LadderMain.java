package nextstep.ladder;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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

        Result.printUsers(users);
        Result.printEmptyLine();
        Result.printLadder(ladder);
        Result.printInputResult(results);
        Result.printEmptyLine();

        String inputResult;
        while (!(inputResult = Input.getInputResult()).equals("all")) {
            final String userName = inputResult;

            int index = IntStream.range(0, users.size())
                    .filter(i -> users.get(i).getUserName().equals(userName))
                    .findFirst()
                    .orElseThrow(() -> {
                        throw new IllegalArgumentException();
                    });

            Result.printResult(ladder.getLines(), users, results, index);
        }
        Result.printAllResult(ladder, users, results);

    }
}
