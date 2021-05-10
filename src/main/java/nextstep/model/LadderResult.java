package nextstep.model;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

    public int size() {
        return this.result.size();
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

    public String resultByIndex(int index) {
        return this.resultList.get(index);
    }

    public void setResult(Player player, String result) {
        this.result.put(player, result);
    }
}
