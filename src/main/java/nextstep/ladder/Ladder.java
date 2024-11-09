package nextstep.ladder;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private Usernames usernames;
    private Lines lines;
    private List<String> results;

    public Ladder(Usernames usernames, Lines lines, List<String> results) {
        this.usernames = usernames;
        this.lines = lines;
        this.results = results;
    }

    public String getResultsForPrint() {
        return results.stream()
                .map(d -> String.format("%-6s", d))
                .collect(Collectors.joining());
    }

    public String getLadderForPrint(String trueSymbol, String falseSymbol) {
        return String.join("\n",
                usernames.toString(),
                lines.toString(trueSymbol, falseSymbol),
                getResultsForPrint()
        );
    }

    public String getResult(String resultUsername) {
        if ("all".equals(resultUsername)) {
            return getAllResult();
        }

        return getResultByUsername(resultUsername);
    }

    private String getAllResult() {
        List<Integer> resultIndexs = lines.getFinalResultIndexs(usernames.size());

        String result = IntStream.range(0, usernames.size())
                .mapToObj(i -> usernames.getValues().get(i).getUsername() + ":" + results.get(resultIndexs.get(i)))
                .collect(Collectors.joining("\n"));
        return result;
    }

    private String getResultByUsername(String resultUsername) {
        int index = usernames.indexOf(resultUsername);
        int resultIndex = lines.getFinalResultIndexs(usernames.size()).get(index);
        return results.get(resultIndex);
    }

}
