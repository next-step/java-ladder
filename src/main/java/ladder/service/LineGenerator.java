package ladder.service;

import ladder.dto.HorizontalLine;

import java.util.List;

public interface LineGenerator {

    List<HorizontalLine> generate(int numberOfUser , int length );
}
