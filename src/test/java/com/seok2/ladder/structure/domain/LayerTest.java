package com.seok2.ladder.structure.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LayerTest {

    @Test
    void build() {
        Layer bottom = Layer.bottom(1);
        BuildStrategy strategy =  (prv) -> null;
        Layer current = bottom.build(strategy);
        assertThat(current.get(0).next()).isEqualTo(bottom.get(0));
    }
}