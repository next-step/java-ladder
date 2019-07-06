package ladder.view;

import ladder.domain.Prize;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
