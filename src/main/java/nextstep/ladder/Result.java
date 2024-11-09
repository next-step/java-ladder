package nextstep.ladder;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Result {

    public static String getResult(String resultUsername, Usernames usernames, Lines lines, List<String> results) {
        if ("all".equals(resultUsername)) {
            return getAllResult(usernames, lines, results);
        }

        return getResultByUsername(resultUsername, usernames, lines, results);
    }

    private static String getAllResult(Usernames usernames, Lines lines, List<String> results) {
        List<Integer> resultIndexs = lines.getFinalResultIndexs(usernames.size());

        String result = IntStream.range(0, usernames.size())
                .mapToObj(i -> usernames.getValues().get(i).getUsername() + ":" + results.get(resultIndexs.get(i)))
                .collect(Collectors.joining("\n"));
        return result;
    }

    private static String getResultByUsername(String resultUsername, Usernames usernames, Lines lines, List<String> results) {
        int index = usernames.indexOf(resultUsername);
        int resultIndex = lines.getFinalResultIndexs(usernames.size()).get(index);
        return results.get(resultIndex);
    }

}
