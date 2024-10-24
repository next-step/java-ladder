# 사다리 게임
## 진행 방법
* 사다리 게임 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/nextstep-step/nextstep-docs/tree/master/codereview)


##  step2 기능 목록

#### - 사다리 라인으로 구성 

* 라인(Line) 기능  
 - [x] 라인의 첫 시작 점은 전달한 값을 갖는다(true전달 시 true로 생성)
 - [x] 라인의 마지막 점은 false
 - [x] 한 줄의 중간 점들은 앞 점의 반대값
   - 앞 점 true -> false 
   - 앞 점 false > true 
 - [x] 점의 모양 
   - true : |-----
   - false : |   
 * Ladder Game
 - [ ] 다리 높이 만큼 줄 생성
 - [ ] 참여 자 만큼 한줄의 점의 갯수 생성

* inputView 
 - [ ] 이름 입력 하여 (Players 객체 생성)
 - [ ] 다리 높이 입력

* OutputView

