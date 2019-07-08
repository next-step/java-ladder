package ladder.formatter;

import ladder.domain.Prizes;

import java.util.stream.Collectors;

public class PrizesPrintFormatter implements DataPrintFormatter<Prizes> {

    @Override
    public String dataPrintFormat(Prizes prizes) {
        return prizes.getPrizes().stream()
                .map(prize -> String.format("%6s", prize.getPrize()))
                .collect(Collectors.joining());
    }
}
