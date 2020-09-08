package step04.model;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class LadderGameResult {
    private Map<LadderUser, Reward> resultMap;

    public LadderGameResult(Map<LadderUser, Reward> resultMap) {
        this.resultMap = resultMap;
    }


    public Map<String, String> getResultMap(String resultUserName, boolean isAll) {
        Map<String, String> stringMap = getStringMap();

        if (isAll) {
            return stringMap;
        }

        return stringMap.keySet()
                .stream()
                .filter(key -> key.equals(resultUserName))
                .collect(Collectors.toMap(key -> key,
                        stringMap::get));
    }

    private Map<String, String> getStringMap() {
        return resultMap.keySet()
                .stream()
                .collect(LinkedHashMap::new,
                        (map, key) -> map.put(key.getName(), resultMap.get(key).getName()),
                        Map::putAll);
    }
}
