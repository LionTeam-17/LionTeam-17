# CaloCheck
`2023.06.19` ~ `2023.07.15
> 건강 관리 종합 서비스
<br/>

## 프로젝트 소개

- 유저 종합 건강 관리 플랫폼
- 식품 종합 정보 제공
- 커뮤니티 및 친구 기능을 가진 소셜 사이트 기능
- 식단 관리 시스템 개인 신체 기록 관리 시스템
- 개인 신체 기록 관리 시스템
<br/>

### [CaloCheck 바로가기](https://www.calocheck.com/)
### [팀 노션](https://www.notion.so/CaloCheck-58b53ac833244efc9941811cd5848587)
### [시연 영상] ()
<br/>

## 팀원


|  [![](https://avatars.githubusercontent.com/u/39723465?v=4)](https://github.com/SeoMoonk)  | [![](https://avatars.githubusercontent.com/u/105156456?v=4)](https://github.com/seongmin8636) | [![](https://avatars.githubusercontent.com/u/125839778?v=4)](https://github.com/Park0720) | [![](https://avatars.githubusercontent.com/u/70837543?v=4)](https://github.com/CatJelly) | [![](https://avatars.githubusercontent.com/u/125889390?v=4)](https://github.com/waimi3169) |
|:------------------------------------------------------------------------------------------:|:-----------------------------------------------------------------------------------------:|:-------------------------------------------------------------------------------------:|:-----------------------------------------------------------------------------------------:|:----------------------------------------------------------------------------------------:|
|                             [김성훈](https://github.com/SeoMoonk)                             |                            [문성민](https://github.com/seongmin8636)                             |                            [박민준](https://github.com/Park0720)                             |                            [박진용](https://github.com/CatJelly)                            |                            [이창준](https://github.com/waimi3169)                            |
`
<br/>

## ERD 다이어그램
![](https://www.notion.so/image/https%3A%2F%2Fs3-us-west-2.amazonaws.com%2Fsecure.notion-static.com%2Fcac45338-801c-4546-88a7-862a8f377aed%2FQuickDBD-Free_Diagram.png?id=aad70438-b6eb-4def-95d2-a03a95520456&table=block&spaceId=f2f896dd-5099-4323-97e3-188f46599528&width=2000&userId=89485743-43c3-4477-81b2-4afcd2966d21&cache=v2)
<br/>

## 사용 기술

<br/>

## 시스템 아키텍처

<br/>

## 주요 기능

### 로그인 및 회원가입
- 일반 회원가입과 이를 바탕으로 한 일반 로그인이 가능합니다.
- 회원가입 시에는 아이디, 비밀번호, 이메일, 성별, 닉네임을 필수로 받아옵니다
- 카카오, 네이버, 구글을 이용한 소셜 로그인이 가능합니다.
---

### Food


| ![](https://velog.velcdn.com/images/waimi3169/post/c432bf47-3c67-4a89-8c9b-cb98becb6dc0/image.png) | ![](https://velog.velcdn.com/images/waimi3169/post/279ed0c8-2281-47ff-97e9-a19970c05512/image.png) | 
|:--------------------------------------------------------------------------------------------------:|:--------------------------------------------------------------------------------------------------:|
|                                             음식 검색 페이지                                              |                                             음식 상세 페이지                                              |   

**Search**
- 키워드를 통해 음식 검색 가능
- 검색페이지에서는 음식번호, 식품명, 제조사 정보 표시하며 리스트로 정렬
- 한 페이지에 10개씩 보여지게 정렬

**FoodInfoDetail**
- 음식의 영양 상세 정보 표시
- 영양 정보 표시를 그래프, 텍스트 방식으로 표현
- 탄수화물, 단백질, 지방 뿐 아니라 각종 영양상세정보제공

---

### 바디 트래킹

| ![](https://velog.velcdn.com/images/waimi3169/post/c432bf47-3c67-4a89-8c9b-cb98becb6dc0/image.png) |  
|:--------------------------------------------------------------------------------------------------:|
|                                               트래킹 화면                                               |     

- 유저의 체중, 골격근량, 체지방량의 변화 기록
- 기록한 날짜별로 최신순으로 그래프와 표로 변화량 확인 가능
- 유저의 BMI 등의 신체지수 계산결과 정보 제공

---

### 커뮤니티

| ![](https://velog.velcdn.com/images/waimi3169/post/007c8877-c6ce-405b-aa95-589efa666aa6/image.png) | ![](https://velog.velcdn.com/images/waimi3169/post/43f94472-4b50-42e6-8da4-7d65380f9339/image.png) | 
|:--------------------------------------------------------------------------------------------------:|:--------------------------------------------------------------------------------------------------:|
|                                            커뮤니티 게시판 페이지                                            |                                             게시글 작성 페이지                                             |

- 종합게시판과 식단 공유 게시판 선택해서 게시 및 포스팅 가능
- 추천순, 최신순으로 선택해서 포스팅 가능
- 게시글 등록, 수정, 삭제 가능 및 권한 부여
- 게시글에 댓글 기능
- 게시글 등록 시에 이미지 등록 기능

---

### 장바구니


| ![](https://velog.velcdn.com/images/waimi3169/post/007c8877-c6ce-405b-aa95-589efa666aa6/image.png) | ![](https://velog.velcdn.com/images/waimi3169/post/43f94472-4b50-42e6-8da4-7d65380f9339/image.png) | 
|:--------------------------------------------------------------------------------------------------:|:--------------------------------------------------------------------------------------------------:|
|                                            커뮤니티 게시판 페이지                                            |                                             게시글 작성 페이지                                             |

- 

---

### DailyMenu

| ![](https://velog.velcdn.com/images/waimi3169/post/18c3b286-f4e9-4549-92e4-0e43645d0931/image.png) |  
|:--------------------------------------------------------------------------------------------------:|
|                                            데일리메뉴 달력페이지                                             |

- 내가 먹은 식단 날짜별로 확인 가능
- 날짜 클릭하면 아침, 점심, 저녁 순으로 식단 표시
- 식단별 영양정보반영

---

### 음식 추천 페이지

| ![](https://velog.velcdn.com/images/waimi3169/post/20f6af96-79a6-40f4-b3d3-749dc83cb4dd/image.png) |  
|:--------------------------------------------------------------------------------------------------:|
|                                             추천 페이지 화면                                              |

- 선택한 영양소별 해당 영양소가 풍부한 음식 추천
- 영양소 선택 시 간단한 영양소 정보 설명
- 음식별 해당 연관 검색 식품 정보 제공

---

### 마이페이지

| ![](https://velog.velcdn.com/images/waimi3169/post/14a7e7c0-eb92-4d8f-a9a9-b7dcd3652dc9/image.png) | ![](https://velog.velcdn.com/images/waimi3169/post/171dc10b-0c29-4907-9299-7fcf5e0d23d2/image.png) | ![](https://velog.velcdn.com/images/waimi3169/post/baaa5075-c859-4a06-aea6-cdbf2fe51ae6/image.png) | ![](https://velog.velcdn.com/images/waimi3169/post/12ef627d-4d2d-456b-9b3a-786428921924/image.png) |
|:--------------------------------------------------------------------------------------------------:|:--------------------------------------------------------------------------------------------------:|:--------------------------------------------------------------------------------------------------:|:--------------------------------------------------------------------------------------------------:|
|                                              내 신체정보                                                |                                               나의 권장량                                               |                                              내가 쓴 포스트                                              |                                            인적사항 변경 페이지                                             |

- 내 정보, 내 권장량, 내 포스트를 볼 수 있는 페이지
- 회원의 신체정보 수정 가능
- 회원이 쓴 글들 페이징 처리로 보기 가능
- 친구등록/친구리스트 이동
- 친구등록하면 친구의 페이지 보기 가능
___
- spring boot : 3.1.0
- db : mariadb

### 프로젝트 개요
- 칼로리 체크
- 식단 정보 저장
- 체중 관리 그래프
- 음식 검색
- 게시판 
