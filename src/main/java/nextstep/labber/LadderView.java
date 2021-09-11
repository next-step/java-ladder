package nextstep.labber;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderView {
    private final BufferedReader bufferedReader;

    public LadderView(BufferedReader bufferedReader) {
        this.bufferedReader = bufferedReader;
    }

    public List<User> participantsList() throws IOException {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        return Arrays.stream(this.bufferedReader.readLine().split(","))
                .map(name -> new User(name))
                .collect(Collectors.toList());
    }

    public int enterLadderHeight() throws IOException {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return Integer.parseInt(this.bufferedReader.readLine());
    }

    public void drawParticipants(List<User> list) {
        list.stream()
                .forEach(user -> {
                    System.out.print(user.toString());
                    IntStream.range(0, User.NAME_SPACE_SIZE - user.toString().length())
                            .mapToObj(i -> " ")
                            .forEach(System.out::print);
                    System.out.print(" ");
                });
        System.out.println();
    }

    public void drawLadder(List<Line> ladder) {
        for (int i = 0; i < ladder.size(); i++) {
            drawLine(ladder.get(i));
        }
    }

    private void drawLine(Line line) {
        for (int j = 0; j < line.size(); j++) {
            System.out.print("|");
            drawPoints(line.move(j));
        }
        System.out.println();
    }

    private void drawPoints(Compass compass) {
        if (compass == Compass.RIGHT) {
            drawPoint("-");
            return;
        }

        drawPoint(" ");
    }

    private void drawPoint(String s) {
        for (int k = 0; k < User.NAME_SPACE_SIZE; k++) {
            System.out.print(s);
        }
    }

    private void drawPoints(int length) {
        IntStream.range(0, User.NAME_SPACE_SIZE - length)
                .mapToObj(i -> " ")
                .forEach(System.out::print);
    }

    public List<String> enterResult() throws IOException {
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        return Arrays.asList(this.bufferedReader.readLine().split(","));
    }

    public void drawProduct(List<String> result) {
        result.stream()
                .forEach(resultStr -> {
                    System.out.print(resultStr);
                    drawPoints(resultStr.length());
                    System.out.print(" ");
                });
        System.out.println();
    }

    public String findResult() throws IOException {
        System.out.println("결과를 보고 싶은 사람은?");
        return this.bufferedReader.readLine();
    }

    public void drawResult(String entered, List<String> result, Map<String, Integer> allResult) {
        System.out.println("실행결과");
        if ("all".equals(entered)) {
            this.drawAllResult(result, allResult);
            return;
        }

        System.out.println(result.get(allResult.get(entered)));
        System.out.println();
    }

    public void drawAllResult(List<String> result, Map<String, Integer> allResult) {
        for (Map.Entry<String, Integer> entry : allResult.entrySet()) {
            System.out.println(entry.getKey() + " : " + result.get(entry.getValue()));
        }
    }
}
