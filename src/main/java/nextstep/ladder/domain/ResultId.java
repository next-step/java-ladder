package nextstep.ladder.domain;

import java.util.Objects;

public class ResultId {

    private Long id;

    public ResultId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ResultId resultId = (ResultId) o;

        return Objects.equals(id, resultId.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

}
