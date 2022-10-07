package ladder.service;

import ladder.model.HorizontalLine;

import java.util.List;

@FunctionalInterface
public interface LineGenerator {

    List<HorizontalLine> generate(int numberOfUser , int length );
}
