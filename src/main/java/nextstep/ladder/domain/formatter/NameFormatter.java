package nextstep.ladder.domain.formatter;

public class NameFormatter implements Formatter {

    @Override
    public String format(String input) {
        return String.format("%5s", input);
    }

}
