package com.seok2.ladder.structure.domain;

public interface BuildStrategy {

    Pillar apply(Pillar previous);
}
