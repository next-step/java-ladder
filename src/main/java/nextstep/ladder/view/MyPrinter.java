package nextstep.ladder.view;

public class MyPrinter {
    private MyPrinter() {}

    public static void printLine(String text) {
        System.out.println(text);
    }

    public static void print(char character) {
        System.out.print(character);
    }
    public static void print(String character) {
        System.out.print(character);
    }

    public static void lineChange() {
        System.out.println();
    }

}
