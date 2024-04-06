# 🪜 사다리 타기
1. 기능 요구 사항
2. 프로그래밍 요구 사항
3. 구조 
4. 여담

---

## 1. 기능 요구 사항
- 사다리 게임에 참여하는 사람의 이름 길이는 최대 5까지 가능
- 사람 이름은 쉼표(,)를 기준으로 구분
- 사람 이름을 5자 기준으로 출력하기 때문에 사다리 폭도 넓어져야 함
- 사타디 타기가 정상적으로 동작하려면 라인이 겹치지 않아야 함
   - `|-----|-----|` 모양과 같이 가로 라인이 겹치는 경우 어느 방향으로 이동할지 결정할 수 없음

## 2. 프로그래밍 요구 사항
- 자바 8의 스트림과 람다를 적용
- 모든 엔티티를 작게 유지

---

## 3. 구조

### LadderController
- 사다리 게임의 실행을 담당하는 Controller

### LadderGenerator
- `Ladder`(= 사다리 객체)의 생성을 담당

### LadderGeneratorStrategy
- 사다리 생성의 전략 패턴
- 일급 컬렉션 적용

### RandomLadderGeneratorStrategy
- `LadderGeneratorStrategy`를 상속 받음
- `RandomBooleanGenerator`의 `generate()`에서 반환하는 랜덤 결과에 따라 사다리를 놓을지 말지를 결정

### RandomLadderBooleanGenerator
- `Random()`의 `nextBoolean()`을 통해 `true` or `false`를 반환

### Ladder
- `List`에 `Line`(= `List<Boolean>`)을 저장하는 사다리 객체
- N번째 `List`에는 N번째 줄의 사다리에 대한 정보가 저장됨
- [x] 특정 `index`에서 사다리 타기를 시작해서 마지막으로 도착하는 `index`를 반환

### Line
- `List<Boolean>` 형식의 클래스 변수를 가지며, 이는 N번째 인덱스(=참가자)에 사다리가 놓여져(=연결되어)있는지 판단
- `isConnectedLadder`로 N번째 참가자의 사다리가 다음 참가자의 사다리와 연결되어있는지 확인 가능
- [x] 특정 `index`에서 사다리 타기를 시작해서 다음 지점에 도착하는 `index`를 반환

### Participants
- 사다리 게임에 참여하는 유저들의 정보를 `List<Participant>`로 저장
- [x] 특정 참가자가 존재할 경우, 해당 참가자를 반환
  - [x] 특정 참가자가 존재하지 않을 경우, 에러 반환
  - [x] `all`로 참가자를 조회할 경우, 모든 참가자를 반환

### Participant
- 사다리 게임에 참여하는 유저 1명의 이름을 `participant`로 저장
- 유저의 이름 길이는 최대 5까지 가능
- [x] 참가자의 사다리타기 참가 지점을 `startPoint`로 저장

### Prizes
- [x] 사다리 타기 상품 목록을 저장하며, `List<String>`을 매개 변수로 `List<Prize>`를 인스턴스 변수로 가지는 클래스
  - [x] 이때 `List<Prizes>`의 사이즈는 `Participants.getNumberOfParticipants()`와 동일해야함 

### Prize
- [x] 사다리 타기 상품 1개를 저장

### LadderGameResult
- [x] 사다리 타기 우승자 정보를 `Map<Participant, Prize>` 인스턴스 변수로 저장하는 클래스
- [x] 우승자 정보는 `Ladder`, `Participants`, `Prizes`를 매개변수로 받아 생성
- [x] 우승자를 `key`값으로 받아 `Prize`를 `value`로 반환하되, 존재하지 않을 경우 에러 반환

### InputView
- 참여할 사람의 이름을 받아, `List<String>`으로 반환
- 최대 사다리 높이를 입력 받음
- [x] 실행 결과 (= 상품 목록)을 입력 받음
- [x] 결과를 보고 싶은 사람, 또는 전체 대상을 입력 받음

### OutputView
- 실행 결과를 출력
- 사다리 출력은 `LadderDrawing`에서 관련 메서드를 호출
- [x] 사다리 게임의 상품을 출력
- [x] 결과를 보고 싶은 대상의 실행 결과를 출력

### LadderDrawing
- 실행 결과에 출력될 사다리를 그림

### 테스트 코드
- `LadderGeneratorTest.java`
- `LadderTest.java`
  - [x] 특정 `index`에서 사다리 타기를 시작해서 마지막으로 도착하는 `index`를 반환 
- `LineTest.java`
  - [x] 특정 `index`에서 사다리 타기를 시작해서 다음으로 도착하는 `index`를 반환
- `ParticipantsTest.java`
  - [x] 특정 참가자가 존재할 경우, 해당 참가자를 반환
    - [x] 존재하지 않을 경우 에러 반환 
  - [x] `all`로 참가자를 조회할 경우, 모든 참가자를 반환
- `ParticipantTest.java`
  - 신규 추가된 기능들이 복잡한 로직, 또는 유효성 검증이 필요되는 로직이 아니므로 신규 테스트 추가 X
- `PrizesTest.java`
  - [x] 사다리 타기 참가자 인원과 상품 숫자가 맞지 않을 경우, 에러 반환
- `PrizeTest.java`
  - 해당 건은 문제에 따로 규약이 존재하거나 복잡한 로직이 필요되지 않으므로, 테스트 클래스에서 제외
- `LadderGameResultTest.java`
  - [x] 우승자를 `Key`값으로 받아 `Prize`를 반환하되, 존재하지 않을 경우 에러 반환

---

## 4. 여담
- 아래 2개는 문제에서 최대 값에 대한 제한이 없었으므로, 유효성 검증을 따로 하지는 않음
  - 사다리 게임에 참여하는 유저의 수
  - 사다리 높이의 최대 길이에 대한 제한
