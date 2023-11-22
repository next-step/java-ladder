package me.namuhuchutong.ladder.dto;

import me.namuhuchutong.ladder.domain.wrapper.Name;
import me.namuhuchutong.ladder.domain.wrapper.Result;

import java.util.Map;
import java.util.Optional;

public class NameAndResult {

    private final Map<Name, Result> values;

    public NameAndResult(Map<Name, Result> values) {
        this.values = values;
    }

    public Result getResult(String inputName) {
        Name name = new Name(inputName);
        if (name.getName().equals("all")) {
            return getAllResults();
        }
        return Optional.ofNullable(values.get(name))
                       .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 키 값입니다. - " + name));
    }

    private Result getAllResults() {
        return null;
    }

    @Override
    public String toString() {
        return "{" + values + '}';
    }
}
