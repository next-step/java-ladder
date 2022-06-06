package view;

import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.StringJoiner;
import java.util.stream.Collectors;
import ladder.Ladder;
import ladder.Line;
import ladder.Name;
import ladder.Players;
import ladder.Prize;
import ladder.Prizes;
import ladder.LadderResults;

public class LadderOutputView {

  private static final String MESSAGE_FOR_WRONG_PLAYER_NAME = "잘못된 플레이어 이름입니다.";
  private static final String RESULT_INFO = "실행결과";
  private static final String LADDER_RESULT = "사다리 결과\n";
  private static final String LINE = "|";
  private static final String POINT = "-----";
  private static final String NOT_POINT = "     ";
  private static final String NEW_LINE = "\n";
  private static final String BLANK = " ";
  private static final String PLAYER_AND_PRIZE_DELIMITER = " : ";
  private static final int NAME_DISTANCE = 6;


  public void printLadderInfo() {
    print(LADDER_RESULT);
  }

  public void printLadder(Players players, Ladder ladder, Prizes prizes) {
    printLadderInfo();
    printPlayerNames(players);
    List<Line> lines = ladder.lines();
    StringJoiner stringJoiner = new StringJoiner(NEW_LINE);
    for (Line line : lines) {
      stringJoiner.add(lineToString(line));
    }
    print(stringJoiner.toString());
    printPrizes(prizes);
  }

  public void printPlayerNames(Players players) {
    List<String> names = players.playerNames()
        .stream()
        .map(Name::toString)
        .collect(Collectors.toUnmodifiableList());
    StringBuilder stringBuilder = new StringBuilder();
    for (String name : names) {
      stringBuilder.append(name)
          .append(BLANK.repeat(NAME_DISTANCE - name.length()));
    }
    print(stringBuilder.toString());
  }

  public void printWrongName() {
    print(MESSAGE_FOR_WRONG_PLAYER_NAME);
  }

  public void printPrizes(Prizes prizes) {
    List<String> prizeList = prizes.prizes();
    StringBuilder stringBuilder = new StringBuilder();
    for (String prize : prizeList) {
      stringBuilder.append(prize)
          .append(BLANK.repeat(NAME_DISTANCE - prize.length()));
    }
    print(stringBuilder.toString());
  }

  public void printResultAll(LadderResults ladderResults) {
    Set<Entry<Name, Prize>> results = ladderResults.allPlayersAndResults();
    StringJoiner stringJoiner = new StringJoiner(NEW_LINE);
    for (Entry<Name, Prize> result : results) {
      stringJoiner.add(result.getKey() + PLAYER_AND_PRIZE_DELIMITER +  result.getValue());
    }
    print(stringJoiner.toString());
  }

  public void printResult(Prize prize) {
    print(RESULT_INFO + NEW_LINE + prize.toString());
  }


  private String lineToString(Line line) {
    List<Boolean> points = line.points();
    StringBuilder lineStringBuilder = new StringBuilder();
    for (int i = 0; i + 1 < points.size(); i++) {
      lineStringBuilder.append(LINE);
      lineStringBuilder.append(pointToString(points.get(i)));
    }
    lineStringBuilder.append(LINE);
    return lineStringBuilder.toString();
  }

  private String pointToString(Boolean point) {
    if (point) {
      return POINT;
    }
    return NOT_POINT;
  }

  private void print(String text) {
    System.out.println(text);
  }
}
