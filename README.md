# 사다리 게임
## 진행 방법
* 사다리 게임 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/nextstep-step/nextstep-docs/tree/master/codereview)

### Step2 - 사다리(생성)
#### 필요 객체
* InputView - 문자 리스트 입력
  * getStringListInput - delimiter로 구분된 문자열을 입력받아 String[] 형태로 반환
  * getNumberInput - 숫자 입력
* OutputView - 사다리 결과 출력
  * printPrompt - 프롬프트 출력
  * printNames - 이름 리스트 출력
  * printLadder - 사다리 출력
* LadderGame - 사다리 게임을 표현하는 객체
  * 생성자에서 InputView, OutputView를 받는다
  * play - 사다리 게임을 시작하는 메소드
* Participants - Participant 리스트 객체
  * 참가자 숫자에 대한 검증(2명 이상)
  * getNames - Participant 리스트를 반환
  * size - Participant 리스트 사이즈 반환
* Participant - 게임 참가자 객체
  * 이름에 대한 검증(0-5 글자)
  * getName - 참가자 이름을 반환
* Ladder - 아래와 같은 형태의 2차원 배열을 표현하는 객체
```
  1 0 1
  0 1 0
  1 0 0
  0 1 0
  1 0 1
```
  * generate - 사다리 생성 메소드
    * 사다리의 높이와 참여자 목록 입력받아 Ladder 객체 생성
    * 사다리 높이에 대한 검증(1이상)
  * getNames - 사다리의 참가자 이름을 반환
  * getLadder - 사다리의 2차원 배열을 반환
* LadderLine - 사다리 한 줄을 표현하는 객체
```
1 0 1
```
  * getBridgeStatus - 사다리 한 줄의 다리 상태를 반환
  * ladderLine.generator - 사다리 한 줄을 만드는 static 메소드
    * 랜덤으로 0과 1을 생성
    * 1 이 연속으로 2개 이상 생성되지 않도록 한다.

### Step2 코드리뷰 반영
* Bridge 객체 추가
  * boolean 객체로 가로줄 사다리 여부를 의미
  * 다음 사다리의 가로줄 여부를 반환 하는 nextBridge 메소드 추가

### Step3 - 사다리(게임 실행)
* Participant 객체 수정
  * 위치 정보 추가 : 현재 이름만 있지만 사다리를 한칸 이동할 때마다 해당 참여자의 위치 정보 표시
* Results 객체 추가
  * List<Result> 형태로 사다리 결과를 저장
* Ladder 객체 수정
  * move 메소드 추가 : LadderLine.move() 메소드를 호출하여 사다리 이동
* LadderLine 객체 수정
    * move 메소드 추가 : bridge 상태에 따라 다음 위치를 반환 (좌우)
  