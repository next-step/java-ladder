package nextstep.model;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static nextstep.constant.Constant.ALL;

public class LadderResult {
    private Map<Player, String> result;
    private List<String> resultList;

    public LadderResult(List<String> people, String resultString) {
        this.result = new HashMap<>();
        generateResultList(resultString);
        int resultListIndex = 0;
        for (String s : people) {
            this.result.put(new Player(s), resultList.get(resultListIndex++));
        }
    }

    public LadderResult(String people, String resultString) {
        this.result = new HashMap<>();
        List<String> peopleList = Arrays.stream(people.split(","))
                .collect(Collectors.toList());
        generateResultList(resultString);
        int resultListIndex = 0;
        for  (String person : peopleList) {
            this.result.put(new Player(person), resultList.get(resultListIndex++));
        }
    }

    public LadderResult(String[] names, String resultString) {
        generateResultList(resultString);
        int resultListIndex = 0;
        this.result = new HashMap<>();
        for (String name : names) {
            this.result.put(new Player(name), resultList.get(resultListIndex++));
        }
    }

    public int size() {
        return this.result.size();
    }

    public void addValue(Player whoWinner, String playerResult) {
        if (!this.result.containsKey(whoWinner)) {
            throw new IllegalArgumentException("No user");
        }
        this.result.put(whoWinner, playerResult);
    }

    public String personResult(Player player) {
        if (player.player().equalsIgnoreCase(ALL)) {
            return allResult();
        }
        return String.valueOf(this.result.get(player));
    }

    private void generateResultList(String resultString) {
        this.resultList = Arrays.stream(resultString.split(","))
                .collect(Collectors.toList());
    }

    public String allResult() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Player, String> entry : result.entrySet()) {
            sb.append(entry.getKey().player() + " : " + entry.getValue() + "\n");
        }
        return sb.toString();
    }
}
