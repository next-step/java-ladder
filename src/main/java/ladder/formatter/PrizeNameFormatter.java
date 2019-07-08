package ladder.formatter;

import ladder.domain.Prize;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static ladder.utility.NameConstants.BLANK_TO_FILL_THE_NAME_SPACE;
import static ladder.utility.NameConstants.SPACE_FOR_NAME;

public class PrizeNameFormatter implements NameFormatter<Prize> {

    @Override
    public String nameFormat(Prize prize) {
        String name = prize.getPrize();
        int spaceForBlank = SPACE_FOR_NAME - name.length();

        return IntStream.rangeClosed(0, spaceForBlank)
                .mapToObj((integer) -> BLANK_TO_FILL_THE_NAME_SPACE)
                .collect(Collectors.joining())
                .concat(name);
    }
}
