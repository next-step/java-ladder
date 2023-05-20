package ladder.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

  private final BufferedReader reader;

  public InputView() {
    this.reader = new BufferedReader(new InputStreamReader(System.in));
  }

  public List<String> getPlayerName() throws IOException {
    System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
    return Arrays.stream(reader.readLine().split(","))
        .map(String::strip)
        .collect(Collectors.toList());
  }

  public int ladderHeight() throws IOException {
    System.out.println("최대 사다리 높이는 몇 개인가요?");
    return Integer.parseInt(reader.readLine());
  }

  public void tearDown() throws IOException {
    this.reader.close();
  }

  public List<String> getRewords() throws IOException {
    System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
    return Arrays.stream(reader.readLine().split(","))
        .map(String::strip)
        .collect(Collectors.toList());
  }

  public String getResultUserName() throws IOException {
    System.out.println("결과를 보고 싶은 사람은?");
    return reader.readLine();
  }
}
