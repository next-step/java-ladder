package nextstep.ladder.dto;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;

public class ResultDto {
    private Map<String, String> result;

    public ResultDto(Map<String, String> result) {
        this.result = result;
    }

    public Set<Entry<String, String>> allResult() {
        return result.entrySet();
    }

    public String findResult(String name) {
        validContainsName(name);
        return result.get(name);
    }

    private void validContainsName(String name) {
        if (!result.containsKey(name)) {
            throw new IllegalArgumentException("찾을 수 없는 사용자 입니다");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ResultDto resultDto = (ResultDto) o;
        return Objects.equals(result, resultDto.result);
    }

    @Override
    public int hashCode() {
        return Objects.hash(result);
    }
}
