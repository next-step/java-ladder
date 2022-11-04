# 책임
- 외부 정보를 입력
  - 참여자 이름 (,구분)
    - 이름 5자이하
  - 실행결과 (,구분)
    - 꽝,숫자
  - 최대 사다리 높이
    - 숫자
- 사다리 생성
  - 이전 true인 경우 false
  - 이전 false인 경우 true or false
- 사다리 게임시작
  - 이동방향 결정
    - 이전, 현재값을 받아 초기화 
    - 다음 값을 받아 다음 방향 생성
  - 위치 
    - 생성
      - 현재 index와 방향을 가진다
      - 최초 위치는 index 0과 오른쪽 또는 none이다
      - 다음 위치는 index + 1, 이전 방향과 오른쪽 판단값을 이용해 구한다.
      - 마지막 위치의 방향은 왼쪽 또는 none이다
    - 이동
      - 이동시 뱡항에 따라 index값을 변경한다
      - 왼쪽이동시 index -1
      - 오른쪽 이동시 index + 1
  - 사다리행 생성
    - 왼쪽이 true이면 오른쪽은 false만 가진다
    - 왼쪽이 false이면 오른쪽은 true / false를 가진다
  - 사다리 이동
    - 시작 위치 index를 기준으로 왼쪽과 오른쪽 사다리중 true인 곳으로 이동한다
      
    - true false fale true
    -      1 
    - true false fale true
    - Point p = Point.first(true) 오른쪽 -> 1
    - point.next(false) 인쪽 -> -1
    - point.next(true) 오른쪽 + 1
  
- 사다리 게임 결과 계산
  - 위치에 매칭되는 결과 리턴
  - 시작위치 0부터 시작
- 결과를 출력
  - 사람이름 입력
    - 외부에서 입력한 사람이름중 하나여야함
  - 사람이름 all이면 이름 : 결과 순으로 출력

# 역할
- 사다리
  - 사다리행
    - 위치
      - 방향
- 사다리생성
- 사다리게임
- 입력view
- 입력DTO
- 출력view

# 참고
https://edu.nextstep.camp/s/DVVUSLFe/ls/fQt79v5r