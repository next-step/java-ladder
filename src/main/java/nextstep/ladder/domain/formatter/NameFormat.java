package nextstep.ladder.domain.formatter;

public class NameFormat implements Format {

    @Override
    public String formalize(String input) {
        return String.format("%5s", input);
    }

}
