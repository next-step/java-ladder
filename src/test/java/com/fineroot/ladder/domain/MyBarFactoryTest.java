package com.fineroot.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import com.fineroot.ladder.engine.Bar;
import com.fineroot.ladder.factory.BarFactory;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class MyBarFactoryTest {
    @ParameterizedTest
    @DisplayName("Bar 생성")
    @ValueSource(ints = {0,1,2,3})
    void createBars(int index) {
        List<Bar> expected = List.of(
                MyBar.of(false, true),
                MyBar.of(true, false),
                MyBar.of(false, true),
                MyBar.of(true, false));
        List<Bar> actual = BarFactory.createBars(true, false, true);
        assertThat(actual.get(index)).hasToString(expected.get(index).toString());
    }
}
