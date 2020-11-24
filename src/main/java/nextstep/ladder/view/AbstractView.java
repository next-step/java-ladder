package nextstep.ladder.view;

public class AbstractView {

    protected static StringBuilder stringBuilder = new StringBuilder();

    protected static void clear() {
        stringBuilder.setLength(0);
    }

    protected static void print() {
        System.out.println(stringBuilder.toString());
    }

    protected static void printAndClear() {
        print();
        clear();
    }

}
