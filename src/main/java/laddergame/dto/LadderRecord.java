package laddergame.dto;

import laddergame.domain.Ladder;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LadderRecord {
    private final List<LineRecord> record;

    public LadderRecord(List<LineRecord> record) {
        this.record = record;
    }

    public static LadderRecord of(Ladder ladder) {
        List<LineRecord> collect = ladder.getLines()
                .stream()
                .map(LineRecord::of)
                .collect(Collectors.toUnmodifiableList());

        return new LadderRecord(collect);
    }

    public List<LineRecord> getRecord() {
        return Collections.unmodifiableList(record);
    }
}
