# 사다리 게임
## 진행 방법
* 사다리 게임 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/nextstep-step/nextstep-docs/tree/master/codereview)


### step1
- [x] 람다실습1: 익명 클래스를 람다로 전환
- [x] 람다실습2: 람다를 활용해 중복 제거
- [x] map, reduce, filter 실습 1 : sumOverThreeAndDouble()
- [x] map, reduce, filter 실습 2 : printLongestWordTop100()
- [x] Optional 1: 조건에 따른 반환
- [x] Optional 2: 값을 반환
- [x] Optional 3: exception 처리


-----


- 사다리 예시
```
<<출력>>
pobi  honux crong   jk
    |-----|     |-----|
    |     |-----|     |
    |-----|     |     |
    |     |-----|     |
    |-----|     |-----|
```  
```
<<단순화-전체>>    || <<단순화-가로만>>
  a   b   c   d   ||    
0 1 1 1 0 1 1 1   ||  0 1 0 1  
0 1 0 1 1 1 0 1   ||  0 0 1 0
0 1 1 1 0 1 0 1   ||  0 1 0 0
0 1 0 1 1 1 0 1   ||  0 0 1 0
0 1 1 1 0 1 0 1   ||  0 1 0 1
```  

<br>


### step2
- [x] 피드백 반영

- 입력값  
    1. 이름  
          - [x] 빈칸, null 안됨.  
          - [x] 최대 5자  
          - [x] 구분자 : `,`  
    2. 사다리 높이
          - [x] 빈칸, null 안됨.  
          - [x] number 체크 : 숫자형인지 | 양수(>0)인지
      
- 사다리 만들기      
  - 요구사항 : 사다리 타기가 정상적으로 동작하려면 라인이 겹치지 않도록 해야 한다.
        
  - [x] 사다리 한 줄 구현하기      
    - [x] Bridge : 사다리 한 줄의 한 칸     
        - 왼쪽 값에 따라 0/1 결정된다.(0 -> 0,1 / 1 -> 0)
            - [x] Strategy에 따라 결정된다      
        - 첫번째 값은 항상 0이다.
    - Line : 사다리 한 줄
        - 참가자의 수 만큼 칸이 생성된다(Bridge 생성)
        - Bridge 생성 시 Strategy 주입     

- 출력  
  - [x] 사람 이름을 5자 기준으로 출력하기 때문에 사다리 폭도 넓어져야 한다. 
  - [x] 폭에 맞춰 연결된 칸/안된 칸 출력


-----

### step3
- [x] 피드백 반영
  - LadderTest 통과시키기
  - 람다 체이닝 가독성 높이기
  - 변수선언 순서: 상수 -> 인스턴스 변수 순
  - line seperator 쓰기 (`\n` 대신)

- 요구사항
  - 3개 이상의 인스턴스 변수를 가진 클래스를 쓰지 않는다.
  - 실행결과 입력
  - 참여자 개인이름 + all 입력시 결과 출력

- 실행결과 입력
  - [x] 입력받기 & validation 👉 `Names` 클래스 재사용
-결과보기  
  - [x] 참가자 1인 결과 찾기
    - 현재 마지막 값에 대해서 IndexOutOfBoundsException 해결.
  - [x] 참가자 전체 결과 찾기
  - [x] 예약어 all. -> 참가자 이름에서 all 제외시키기
  - 👀 고민해볼 사항:     
     Bridge에서 `Line move()` 에 필요한 index 값을 추출하는 메서드,
     curHasConnected(현재의 hasConnected), nextHasConnected을 추가하면 값 찾기가 수월할듯..?
     => hasConnected 값을 연속적으로 놓아야한다는 점이 까다로움🤔


-----

### step4
- [ ] 피드백 반영
  - LadderView 이동하기👉 LadderResult로 명칭 변경, `domain.game`으로 이동
  - Line `move(int)` 가독성 높이기 -> 메서드 분리

