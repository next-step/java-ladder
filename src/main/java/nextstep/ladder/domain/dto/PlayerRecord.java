package nextstep.ladder.domain.dto;

import java.util.Objects;

public class PlayerRecord {
    private final String record;

    private PlayerRecord(String record) {
        validate(record);

        this.record = record;
    }

    private void validate(String record) {
        if (Objects.isNull(record)) {
            throw new IllegalArgumentException("record는 null이면 안된다");
        }
    }

    public static PlayerRecord of(String record) {
        return new PlayerRecord(record);
    }

    public static PlayerRecord empty() {
        return new PlayerRecord("");
    }

    public String getRecord() {
        return record;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PlayerRecord that = (PlayerRecord) o;

        return record != null ? record.equals(that.record) : that.record == null;
    }

    @Override
    public int hashCode() {
        return record != null ? record.hashCode() : 0;
    }
}
