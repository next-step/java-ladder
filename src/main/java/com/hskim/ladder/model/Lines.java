package com.hskim.ladder.model;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lines {
    private static final String INVALID_STATE = "사다리가 생성되지 않아 경로를 탐색할 수 없습니다!";

    private final List<Line> lines;

    public Lines(List<Line> lines) {
        this.lines = lines;
    }

    public static Lines of(int lineNum, int userNum, RowIndexMaker rowIndexMaker) {
        return new Lines(Collections.unmodifiableList(
                IntStream.range(0, lineNum)
                        .mapToObj(i -> new Line(new LadderLineIterator(userNum), rowIndexMaker))
                        .collect(Collectors.toList())
        ));
    }

    public List<List<LadderPoint>> getLines() {
        return lines.stream()
                .map(Line::getLadderPoints)
                .collect(Collectors.toList());
    }

    public Map<Integer, Integer> getStartEndPointMap() {
        if (lines.isEmpty()) {
            throw new IllegalStateException(INVALID_STATE);
        }

        List<Map<Integer, Integer>> startEndPointMapList = lines.stream()
                .map(Line::getStartEndPointMap)
                .collect(Collectors.toList());

        Map<Integer, Integer> resultMap = new LinkedHashMap<>();

        for (Map<Integer, Integer> map : startEndPointMapList) {
            navigate(map.keySet(), map, resultMap);
        }

        return resultMap;
    }

    private void navigate(Set<Integer> keySet, Map<Integer, Integer> target, Map<Integer, Integer> resultMap) {
        for (Integer integer : keySet) {
            resultMap.put(integer, target.get(resultMap.getOrDefault(integer, integer)));
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Lines)) return false;
        Lines lines1 = (Lines) o;
        return Objects.equals(lines, lines1.lines);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lines);
    }
}
