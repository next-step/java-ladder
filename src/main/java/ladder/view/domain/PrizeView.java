package ladder.view.domain;

import ladder.domain.Prize;
import ladder.domain.Prizes;

public class PrizeView implements DomainPrintable<Prizes> {
    private static final String PRIZE_FORMAT_EXPRESSION = "%-5s";
    private static final String BLANK_STRING = " ";

    @Override
    public void print(final Prizes prizes) {
        prizes.getPrizes()
              .stream()
              .map(Prize::getPrize)
              .map(PrizeView::formatPrize)
              .forEach(System.out::print);
    }

    private static String formatPrize(String name) {
        return String.format(PRIZE_FORMAT_EXPRESSION, name) + BLANK_STRING;
    }
}
