package ladder.view;

public interface BaseView {

    default void printlnMessageAfterNewLine(String message) {
        System.out.print(System.lineSeparator());
        System.out.println(message);
    }

    default void printlnMessage(String message) {
        System.out.println(message);
    }

    default void printMessage(String message) {
        System.out.print(message);
    }

    default void printNewLine() {
        System.out.print(System.lineSeparator());
    }
}
