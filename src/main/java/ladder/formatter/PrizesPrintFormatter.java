package ladder.formatter;

import ladder.domain.Prize;
import ladder.domain.Prizes;

import java.util.stream.Collectors;

public class PrizesPrintFormatter implements DataPrintFormatter<Prizes> {

    private final NameFormatter<Prize> prizeNameFormatter = new PrizeNameFormatter();

    @Override
    public String dataPrintFormat(Prizes prizes) {
        return prizes.getPrizes().stream()
                .map(prize -> String.format(prizeNameFormatter.nameFormat(prize), prize.getPrize()))
                .collect(Collectors.joining());
    }
}
