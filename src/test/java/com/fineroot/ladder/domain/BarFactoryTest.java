package com.fineroot.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BarFactoryTest {
    @ParameterizedTest
    @DisplayName("Bar 생성")
    @ValueSource(ints = {0,1,2,3})
    void createBars(int index) {
        List<Bar> bars = new ArrayList<>();
        List<Bar> expected = List.of(
                Bar.of(false, true),
                Bar.of(true, false),
                Bar.of(false, true),
                Bar.of(true, false));
        List<Bar> actual = BarFactory.createBars(true, false, true);
        assertThat(actual.get(index)).hasToString(expected.get(index).toString());
    }
}
