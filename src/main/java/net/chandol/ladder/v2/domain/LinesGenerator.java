package net.chandol.ladder.v2.domain;

import java.util.List;

public interface LinesGenerator {
    List<Line> generate(int size, int height);
}
