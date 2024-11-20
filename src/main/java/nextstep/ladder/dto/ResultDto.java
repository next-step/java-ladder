package nextstep.ladder.dto;

import java.util.Map;
import java.util.Objects;

public class ResultDto {
    private Map<String, String> result;

    public ResultDto(Map<String, String> result) {
        this.result = result;
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
