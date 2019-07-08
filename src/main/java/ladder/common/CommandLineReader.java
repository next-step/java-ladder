package ladder.common;

import java.util.Scanner;

public class CommandLineReader {

    private Scanner scanner = new Scanner(System.in);

    public PositiveNumber readNumber() {
        return PositiveNumber.of(scanner.nextLong());
    }

    public Csv readCsv() {
        return Csv.ofString(scanner.next());
    }
}