package com.seok2.ladder.structure.domain;

public interface BuildStrategy {

    Line apply(Line previous);
}
