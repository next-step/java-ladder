package ladder.domain;

import ladder.dto.LineGenerateDto;

import java.util.List;
import java.util.function.Supplier;


public interface LineGenerator {

    List<HorizontalLine> generate(LineGenerateDto lineGenerateDto , Supplier<Boolean> LineGeneratePolicy);
}
