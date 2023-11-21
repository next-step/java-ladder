package me.namuhuchutong.ladder.domain;

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
        return Optional.ofNullable(values.get(name))
                       .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 키 값입니다. - " + name));
    }

    @Override
    public String toString() {
        return "{" + values + '}';
    }
}
