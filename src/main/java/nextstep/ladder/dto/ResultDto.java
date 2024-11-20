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
