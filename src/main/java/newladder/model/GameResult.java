package newladder.model;

import java.util.HashMap;

public class GameResult {

    private final HashMap<String, String> resultList = new HashMap<>();

    public void addResult(String userName, String prizeName) {
        resultList.put(userName, prizeName);
    }

    public HashMap<String, String> getResult() {
        return resultList;
    }

    public String getResult(String name) {
        if (resultList.containsKey(name)) {
            return resultList.get(name);
        }
       throw new IllegalArgumentException();
    }

}
