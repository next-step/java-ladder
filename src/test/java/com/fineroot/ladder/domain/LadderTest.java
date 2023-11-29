package com.fineroot.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderTest {

    @Test
    @DisplayName("Ladder 생성")
    void create() {
        Ladder ladder = Ladder.of(Users.fromString("a,b,c,d"),5);
        assertThat(ladder).isInstanceOf(Ladder.class);
    }
}
