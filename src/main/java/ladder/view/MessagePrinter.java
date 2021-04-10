package ladder.view;

public class MessagePrinter {

    public static void printlnMessageAfterNewLine(String message) {
        System.out.print(System.lineSeparator());
        System.out.println(message);
    }

    public static void printlnMessage(String message) {
        System.out.println(message);
    }

    public static void printMessage(String message) {
        System.out.print(message);
    }

    public static void printNewLine() {
        System.out.print(System.lineSeparator());
    }
}
