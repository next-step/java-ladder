# 코드 리뷰 이전

## 사다리(게임 실행)

### 역할

#### 컨트롤러

1. 사다리 프로그램의 입출력과 도메인 로직을 활성화하 사다리 컨트롤러 객체

#### 도메인

#### 게임

2. 사다리 게임을 진행해주는 게임 객체

3. 사다리 게임의 결과를 저장하고 쿼리의 결과를 반환해주는 게임결과 객체

#### 사다리맵

4. 사다리의 높이를 검증하는 사다리 높이 객체

5. 사다리를 탈 이름과 완성된 사다리를 가지는 사다리맵 객체

6. 사다리맵의 가로줄을 담당하는 줄 객체

7. 점들의 연결을 의미하는 링크 객체

8. 사다리의 점을 담당하는 점 객체

#### 이동전략

9. 왼쪽 이동 객체

10. 오른쪽 이동 객체

11. 제자리 객체

12. 이동전략 인터페이스

13. 이동전략을 정해주는 이동전략 심판

#### 참가자

14. 참가자의 이름을 담당하는 참가자 객체

15. 참가자들을 담당하는 참가자 리스트 객체

#### 결과

16. 사다리타기로 나올수 있는 결과를 저장하는 결과 객체

17. 결과들을 저장하는 결과리스트 객체

#### 뷰

18. 사용자 입력을 받아주는 인풋 뷰

19. 결과를 출력해주는 결과 뷰

### 책임

#### 컨트롤러

1. 사다리 프로그램의 입출력과 서비스 활성화를 담당하는 사다리 컨트롤러 객체

- 입출력을 담당해야 한다
- 도메인을 통해 입력값을 검증해야 한다
- 도메인의 결과를 출력할 수 있게 전달해야 한다

#### 도메인

#### 게임

2. 사다리 게임을 진행해주는 게임 객체

- 사다리 타기 게임을 진행해주어야 한다
- 사다리 타기 게임의 결과를 반환해야 한다

3. 사다리 게임의 결과를 저장하고 쿼리의 결과를 반환해주는 게임결과 객체

- 사다리 타기 게임의 결과를 저장해야 한다
- 사다리 타기 참가자들의 결과를 알려주어야 한다

#### 사다리맵

4. 사다리의 높이를 검증하는 사다리 높이 객체

- 음수값은 허용하지 않아야 한다

5. 사다리를 탈 이름과 완성된 사다리를 가지는 사다리맵 객체

- 사용자들의 이름을 가져야 한다
- 세로로, 그리고 가로로 연결된 사다리를 가져야 한다
- 사다리를 타고 내려갔을 때의 결과를 반환해야 한다

6. 사다리맵의 가로줄을 담당하는 줄 객체

- 점의 리스트를 가져야 한다
- 링크의 리스트를 가져야 한다
- 줄 안에서 이동할 수 있는 인덱스를 반환해주어야 한다

7. 점들의 연결을 의미하는 링크 객체

- 링크 안에서 이동할 수 있는 인덱스를 반환해주어야 한다

8. 사다리의 점을 담당하는 점 객체

- 자신의 위치를 기억해야 한다
- 이동방향이 주어졌을 때 해당 방향으로 이동해야 한다

#### 이동전략

9. 왼쪽 이동 객체

- 이동전략으로 왼쪽을 담아야 한다

10. 오른쪽 이동 객체

- 이동전략으로 오른쪽을 담아야 한다

11. 제자리 객체

- 이동전략으로 제자리를 담아야 한다

12. 이동전략 인터페이스

- 이동전략을 담아야 한다

13. 이동전략을 정해주는 이동전략 심판

- 이전 링크를 통해 다음 이동전략을 알려주어야 한다
- 이전 링크가 오른쪽으로 이동했을 때는 왼쪽을 반환한다
- 이전 링크가 오른쪽이 아닐 경우에는 50%의 확률로 제자리, 혹은 오른쪽을 반환한다

#### 참가자

14. 참가자의 이름을 담당하는 참가자 객체

- 사용자의 이름을 검증해주어야 한다

15. 참가자들을 담당하는 참가자 리스트 객체

- 검증된 참가자의 리스트를 가져야 한다

#### 결과

16. 사다리타기로 나올수 있는 결과를 저장하는 결과 객체

- 결과를 저장해야 한다

17. 결과들을 저장하는 결과리스트 객체

- 결과들을 저장해야 한다
- 참가자들의 수와 결과의 수가 같은지 검증해주어야 한다

#### 뷰

18. 사용자 입력을 받아주는 인풋 뷰

- 이름을 받아주어야 한다
- 사다리타기로 나올 수 있는 결과를 받아주어야 한다
- 사다리 높이를 받아주어야 한다
- 결과를 보고 싶은 사람의 이름을 받아주어야 한다

19. 결과를 출력해주는 결과 뷰

- 완성된 사다리맵을 출력해주어야 한다
- 사다리 타기의 결과를 출력해주어야 한다

# 커밋 로그 해설
> 프로젝트 진행 과정을 한 눈에 확인하기 위해 제작. 자세한 내용은 실제 커밋에 나와있습니다.
```html

<h3>Preparation</h3>

feat(step4): rm -rf step3 codes
tdd로 기능을 재구현하기 위해 이전에 작성한 코드를 모두 삭제

<h3>Participant</h3>

feat(participant): make participant generation test code
참가자의 이름을 잘 생성하는지 테스트 코드 생성

feat(participant): generate codes that meet the test code needs
참가자의 이름을 실제로 생성하는 코드 생성

feat(participant): add test codes to test white space in input
띄어쓰기가 양옆으로 있는 인풋 테스트 코드 생성

feat(participant): add codes that meet the test codes
띄어쓰기를 제거하는 코드 생성

feat(participant): add participant name validation
5글자 이상 인풋에 대헤서는 에러를 던지는 코드 추가

<h3>Participant List</h3>

feat(participantList): add participantList generation
참가자 컬렉션을 만드는 코드 추가

feat(participantList): add participant get and size
참가자 조회 및 규모 조회 코드 추가

<h3>Ladder Height</h3>

feat(ladder height): add ladder height generation code
사다리 높이를 만드는 코드 추가

feat(ladder height): add ladder height validation code
사다리 높이를 검증하는 코드 추가

<h3>Point</h3>

feat(point): add point generation code
점을 만드는 코드 추가

feat(point): add point validation code
점의 인덱스를 검증하는 코드 추가

<h3>Link</h3>

feat(link): add still link generation code
가만히 있는 링크 생성 코드 추가

feat(link): add left and right link generation code
왼쪽, 오른쪽으로 움직이는 링크 추가

<h3>Refactor</h3>

refact(step4): restructure packages
공통의 주제로 패키지 세분화

<h3>ResultCase</h3>

feat(result case): add result case generation code
결과 생성 코드 추가

<h3>ResultCaseList</h3>

feat(result case list): add result case list generation code
결과 컬렉션 생성 코드 추가

<h3>Refactor</h3>

refact(step4): add final to instance variables
인스턴스 변수 상수화

<h3>MoveStrategyJudge</h3>

feat(move strategy judge): add left move judge
왼쪽 이동을 지시하는 심판 코드 추가

feat(move strategy judge): add right or still judge
가만히 있거나 오른쪽 이동을 지시하는 심판 코드 추가

<h3>Line</h3>

feat(line): add line initialization code
라인 초기화 코드 추가

<h3>LadderMap</h3>

feat(ladder map): add ladder map initialization code
사다리맵 초기화 코드 추가

<h3>View</h3>

feat(view): add controller and input view code
컨트롤러, 참여자리스트, 결과 리스트 인풋 코드 추가

feat(view): add height input and ladder view code
높이 입력 및 사다리 출력 코드 추가

<h3>LadderMap</h3>

feat(ladder map): add ladder map line verification code
사다리맵 검증 코드 추가

<h3>Line</h3>

feat(line): add traversal method
이동한 점을 반환하는 코드 추가

<h3>LadderMap</h3>

feat(ladder map): add ladder traversal method
사다리맵 전체 순회 코드 추가

<h3>Game & GameResult</h3>

feat(game & game result): add game and result method
사다리타기 활성화, 결과를 담는 코드 추가

<h3>view</h3>

feat(view): add result view method
결과 출력 코드 추가

<h3>Docs</h3>

docs(step4): update readme
```
