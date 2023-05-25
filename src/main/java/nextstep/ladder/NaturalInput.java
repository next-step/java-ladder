package nextstep.ladder;

public class NaturalInput {
    private final String input;

    public NaturalInput(String input) {
        this.input = input;
        checkInputIsNaturalNumber();
    }

    public Natural toNatural() {
        return new Natural(Long.parseLong(input));
    }

    private void checkInputIsNaturalNumber() {
        if (!input.matches("\\d+")) {
            throw new IllegalArgumentException("Input is not a natural number");
        }
    }
}
