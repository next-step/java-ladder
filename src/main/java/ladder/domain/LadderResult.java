package ladder.domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class LadderResult {

    public static final String ALL_USERS = "all";
    private final Map<Name, Result> ladderResult;

    public LadderResult(Map<Name, Result> ladderResult) {
        this.ladderResult = ladderResult;
    }

    public static LadderResult createLadderResult(Gamers gamers, Results results) {
        Map<Name, Result> ladderResult = new HashMap<>();

        for (int i = 0; i < gamers.countGamers(); i++) {
            Name name = gamers.findName(i);
            Position position = gamers.findPosition(i);
            Result result = results.getResult(position.getPosition());

            ladderResult.put(name, result);
        }

        return new LadderResult(ladderResult);
    }

    public Map<Name, Result> findPlayerResult(String name) {
        validate(name);

        if (name.equals(ALL_USERS)) {
            return findAllPlayersResult();
        }

        Map<Name, Result> singleResult = new HashMap<>();
        Name findUserName = new Name(name);
        Result result = ladderResult.get(findUserName);

        singleResult.put(findUserName, result);
        return Collections.unmodifiableMap(singleResult);
    }

    private Map<Name, Result> findAllPlayersResult() {
        return Collections.unmodifiableMap(this.ladderResult);
    }

    private void validate(String name) {
        if (!this.ladderResult.containsKey(new Name(name))) {
            throw new IllegalArgumentException("참가자 명단에 없는 사람입니다. 참가자 명단에 있는 사람 혹은 all을 입력 부탁드립니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LadderResult that = (LadderResult) o;
        return Objects.equals(ladderResult, that.ladderResult);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ladderResult);
    }
}
