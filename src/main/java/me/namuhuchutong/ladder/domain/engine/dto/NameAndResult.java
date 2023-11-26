package me.namuhuchutong.ladder.domain.engine.dto;

import me.namuhuchutong.ladder.domain.implement.wrapper.Name;
import me.namuhuchutong.ladder.domain.implement.wrapper.Result;

import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class NameAndResult {

    private static final String NEW_LINE = "\n";
    private static final String DELIMITER = ": ";

    private final Map<Name, Result> values;

    private final LadderResult ladderResult;

    public NameAndResult(Map<Name, Result> values, LadderResult ladderResult) {
        this.values = values;
        this.ladderResult = ladderResult;
    }

    public String getResult(String input) {
        Name name = new Name(input);
        return Optional.ofNullable(values.get(name))
                       .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 키 값입니다. - " + name))
                       .getResult();
    }

    public String getAllResults() {
        return this.values.keySet()
                          .stream()
                          .map(key -> key + DELIMITER + this.values.get(key))
                          .collect(Collectors.joining(NEW_LINE));
    }

    public String showLadderToString() {
        return this.ladderResult.showLadderToString();
    }
}
