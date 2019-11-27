package reladder.service;

import reladder.domain.Person;

import java.util.HashMap;
import java.util.Map;

public class LadderGameResult {

    private LadderGame ladderGame;

    public LadderGameResult(LadderGame ladderGame) {
        this.ladderGame = ladderGame;
    }
    public String getResult(String name) {
        return ladderGame.getResultByName(name);
    }

    public Map<String, Object> getResultAll() {
        Map<String, Object> result = new HashMap<>();
        for (Person person : ladderGame.getPeople()) {
            result.put(person.getName(), ladderGame.getResultByName(person.getName()));
        }
        return result;
    }
}
