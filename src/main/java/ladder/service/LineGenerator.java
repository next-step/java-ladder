package ladder.service;

import ladder.model.HorizontalLine;

import java.util.List;


public interface LineGenerator {

    List<HorizontalLine> generate(int numberOfUser, int length);
}
