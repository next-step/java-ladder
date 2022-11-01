package laddergame.dto;

import java.util.Collections;
import java.util.List;

public class RewordRecords {
    private final List<RewardRecord> records;

    public RewordRecords(List<RewardRecord> records) {
        this.records = records;
    }

    public List<RewardRecord> getRecords() {
        return Collections.unmodifiableList(records);
    }
}
