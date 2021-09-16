package ladder.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LadderGameInfo {

  private final List<LimitedString> participants;
  private final List<LimitedString> results;

  public LadderGameInfo(String participants, String results) {
    this(convertStringToLimitedString(participants), convertStringToLimitedString(results));
  }

  public LadderGameInfo(List<LimitedString> participants, List<LimitedString> results) {
    validateParticipantsAndResults(participants, results);
    this.participants = participants;
    this.results = results;
  }

  public int getParticipantCnt() {
    return participants.size();
  }

  public int getParticipantPosition(String participant) {
    return participants.indexOf((new LimitedString(participant)));
  }

  public String getResultByPosition(int position) {
    return results.get(position).getValue();
  }

  public List<String> getParticipants() {
    return participants.stream()
        .map(LimitedString::getValue)
        .collect(Collectors.toList());
  }

  public List<String> getResults() {
    return results.stream()
        .map(LimitedString::getValue)
        .collect(Collectors.toList());
  }

  private static List<LimitedString> convertStringToLimitedString(String str) {
    return Arrays.stream(str.split(","))
        .map(String::trim)
        .map(LimitedString::new)
        .collect(Collectors.toList());
  }

  private void validateParticipantsAndResults(
      List<LimitedString> participants,
      List<LimitedString> results
  ) {
    if (participants.stream().distinct().count() != participants.size()) {
      throw new IllegalArgumentException("중복된 이름은 허용하지 않습니다.");
    }
    if (participants.size() != results.size()) {
      throw new IllegalArgumentException("참여할 인원과 실행결과의 개수는 같아야합니다.");
    }
  }
}
