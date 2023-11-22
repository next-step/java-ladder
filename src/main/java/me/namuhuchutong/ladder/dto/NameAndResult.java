package me.namuhuchutong.ladder.dto;

import me.namuhuchutong.ladder.domain.wrapper.Name;
import me.namuhuchutong.ladder.domain.wrapper.Result;

import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class NameAndResult {

    private static final String NEW_LINE = "\n";
    private static final String DELIMITER = ": ";

    private final Map<Name, Result> values;

    public NameAndResult(Map<Name, Result> values) {
        this.values = values;
    }

    public String getResult(String inputName) {
        Name name = new Name(inputName);
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
}
