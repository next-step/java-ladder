# 사다리 게임
## 2단계 - 사다리(생성)
1. 기능 구현 사항
   1. 사다리 게임 참여자 이름, 이름 모음 클래스 생성 (ParticipantName, ParticipantNames)
      - ParticipantName: 이름이 최대 5글자인지 타당성 검증
      - ParticipantNames: 참가자가 최소 1명 이상이어야 하는 것 검증
   2. 실행 결과, 결과 모음 클래스 생성 (ExecutionResult, ExecutionResults)
      - ExecutionResults: 참가자 수와 실행 결과 수가 같은지 검증
   3. 사다리를 구성하는 선 도메인 생성 (Line)
      - 연속된 가로선이 있는지 여부 확인하고, 초기화 작업 진행 
      - Line을 만들 때 생성 전략 추가 (MakePointsStrategy interface 구현)
        - RandomMakePointsStrategy: 난수에 의해 생성
        - ForceMakePointsStrategy: 무조건 처음에 true로 두고 생성 (TFTF꼴)
        - FailedMakePointsStrategy: 무조건 true로 생성 (연속된 가로줄 생성)
   4. 사다리 도메인 생성 (Ladder)

## 3단계 - 사다리(게임 실행)
1. 기능 구현 사항
   1. 사다리 실행 결과 출력 (LadderGame으로 게임 진행하고 ResultView로 결과 출력)
      - 개인별 / all 입력 시 각각 다르게 구현
      - 재귀 호출을 위해 '누구의 결과를 확인하기 원하냐'는 질문을 내부에 삽입
   2. LadderGame 구현 시 참가자와 실행 결과가 서로 의존하지 않도록 함
      - LadderGame이 Ladder, 참가자, 실행 결과를 가지는 도메인이 됨. (3개)

## 4단계 - 사다리(리팩토링)
1. 피드백 반영
   1. README.md 업데이트
   2. String[] 대신 List<String>을 사용하여 타입 안정성 유지
   3. Exception message에 어떤 값이 들어왔었는지 흔적 남기기
   4. 3번을 시행하면서 에러 메시지를 상수로 표현하는 것 제거
   5. Ladder가 countOfPerson에 의존을 가지지 않도록 함
      - 이제 초기화된 점들에 의존을 가진다. (List<Boolean> initializedPoints)
   6. ExecutionResults: 참가자 수와 실행 결과 수가 동일해야 함을 검증하는 로직 추가
      - index의 경우 같을 필요가 없음
   7. validate가 throw Exception을 던지는 로직이 되도록 일관성 유지
   8. 같은 동작을 수행하는 객체의 경우 매번 생성되지 않도록 싱글턴 패턴 사용 (MakePointsStrategy 구현체)
   9. Line 도메인에서 생성자에 많은 로직을 가지지 않도록 변경 (List<Boolean> initializedPoints를 인자로 가짐)
   10. 매직 넘버 처리 (ParticipantName, ParticipantNames)
   11. 모든 테스트에서 긍정 케이스를 고려하도록 처리