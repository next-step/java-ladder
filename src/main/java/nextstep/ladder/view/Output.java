package nextstep.ladder.view;

public class Output {

    public Output() {
    }

    public void println(String message) {
        System.out.println(message);
    }

    public void printf(String message, String... args) {
        System.out.printf(message, args);
    }

    public void print(String message) {
        System.out.print(message);
    }
}
