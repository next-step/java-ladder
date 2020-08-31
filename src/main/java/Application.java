import ladder.controller.LadderController;
import ladder.ui.Input;
import ladder.ui.Output;

import java.util.List;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {

        LadderController ladderController = LadderController.builder()
                                                            .input(new ScannerInput())
                                                            .output(new StandardOutput())
                                                            .build();

        ladderController.printLadder();
        ladderController.printResult();
    }

    private static class ScannerInput implements Input {
        private final Scanner scanner = new Scanner(System.in);

        @Override
        public int nextInt() {
            return scanner.nextInt();
        }

        @Override
        public String nextLine() {
            return scanner.nextLine();
        }
    }

    private static class StandardOutput implements Output {
        @Override
        public void print(String line) {
            System.out.println(line);
        }

        @Override
        public void print(List<String> lineList) {
            print(String.join("\t", lineList));
        }

        @Override
        public void printMultiLine(List<String> lineList) {
            lineList.forEach(System.out::println);
        }
    }
}
