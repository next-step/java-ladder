package com.seok2.ladder.game.dto;

import java.util.Collections;
import java.util.Map;

public class ResultDTO {

    private final Map<String, String> result;

    private ResultDTO(Map<String, String> result) {
        this.result = Collections.unmodifiableMap(result);
    }

    public static ResultDTO of(Map<String, String> result) {
        return new ResultDTO(result);
    }

    public Map<String, String> getResult() {
        return result;
    }
}
