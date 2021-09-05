package nextstep.labber;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
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

    public void drawLadder(List<Line> lines) {
        lines.stream()
                .forEach(line -> drawLine(line));
    }

    private void drawLine(Line line) {
        System.out.print("|");
        for (int j = 0; j < line.size(); j++) {
            drawPoints(line.existLine(j));
        }
        System.out.println();
    }

    private void drawPoints(boolean isLine) {
        if (isLine) {
            drawPoint("-");
            System.out.print("|");
            return;
        }

        drawPoint(" ");
        System.out.print("|");
    }

    private void drawPoint(String s) {
        for (int k = 0; k < User.NAME_SPACE_LENGTH; k++) {
            System.out.print(s);
        }
    }

    public void drawParticipants(List<User> list) {
        for (User user : list) {
            System.out.print(user.toString());
            IntStream.range(0, User.NAME_SPACE_LENGTH - user.toString().length())
                    .mapToObj(i -> " ")
                    .forEach(System.out::print);
            System.out.print(" ");
        }
        System.out.println();
    }

}
