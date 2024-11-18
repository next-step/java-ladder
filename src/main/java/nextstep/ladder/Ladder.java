package nextstep.ladder;

import java.util.List;
import java.util.Map;
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

    private Map<String, String> getResultMap() {
        Map<String, String> result = IntStream.range(0, usernames.size())
                .boxed()
                .collect(Collectors.toMap(
                        i -> usernames.getValues().get(i).getUsername(),
                        i -> results.get(lines.getPersonFinalResultIndex(i))
                ));

        return result;
    }

    private String getAllResult() {
        Map<String, String> resultMap = getResultMap();

        return resultMap.entrySet()
                .stream()
                .map(d -> d.getKey()+" : "+d.getValue()).collect(Collectors.joining("\n"));
    }

    private String getResultByUsername(String resultUsername) {
        return getResultMap().get(resultUsername);
    }

}
