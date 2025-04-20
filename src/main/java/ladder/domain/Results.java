package ladder.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Results {
    private final Map<String, String> result;

    public Results(Map<String, String> result) {
        this.result = new HashMap<>(result);
    }

    /**
     * 사다리 게임의 모든 결과를 반환합니다.
     * 
     * @return 결과 맵 (key: 참가자 이름, value: 해당 참가자가 도달한 결과값)
     */
    public Map<String, String> getResult() {
        return result;
    }

    /**
     * 특정 참가자의 결과를 반환합니다.
     * 
     * @param name 결과를 조회할 참가자 이름
     * @return 해당 참가자가 도달한 결과값
     * @throws IllegalArgumentException 존재하지 않는 참가자 이름이 주어진 경우
     */
    public String getResult(String name) {
        if (!result.containsKey(name)) {
            throw new IllegalArgumentException("No such result: " + name);
        }
        return result.get(name);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Results that = (Results) o;
        return Objects.equals(result, that.result);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(result);
    }
}
