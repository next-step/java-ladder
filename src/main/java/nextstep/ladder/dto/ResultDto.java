package nextstep.ladder.dto;

import java.util.Map;
import java.util.Objects;

public class ResultDto {
    private final Map<String, String> result;

    public ResultDto(Map<String, String> result) {
        this.result = Map.copyOf(result);
    }

    private void validContainsName(String name) {
        if (!result.containsKey(name)) {
            throw new IllegalArgumentException("찾을 수 없는 사용자 입니다");
        }
    }

    public Map<String, String> allResult() {
        return result;
    }

    public String findResult(String name) {
        validContainsName(name);
        return result.get(name);
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
