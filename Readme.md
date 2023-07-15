# YummyTrip
 
## 팀원
- 전영호 이정인
 
## 목차
1.	프로젝트 주제
2.	세부 기능
3.	데이터베이스 스키마
4.	클래스 다이어그램
5.	시스템 아키텍쳐
6.	Jwt를 이용한 인증처리
7.	에러 처리
8.	프로젝트 일정
 
## 1. 프로젝트 주제
-	공공데이터 api를 활용한 여행지 계획 사이트.
-	관광지 정보를 불러오는데 공공데이터 api를 사용하였다.
-	여행계획을 세우는데, 직관적으로 위치를 알수있어야 하기 때문에, 카카오지도 api를 사용하였다.


 
## 2.	 주요 기능
### 	여행 계획
- 	사용자는 메인화면을 통해 plan 창을 통해 계획을 작성할수있다.
 ![그림1](https://github.com/ssafy9-finalproject/frontServer/assets/70370578/114d1eb4-9e06-4cb7-919c-0084ee592f79)
 
- 	Plan창에서 출발 날짜, 돌아오는 날짜를 고르고, 여행지를 검색한다.
- 	여행지를 검색하면, 해당 좌표의 지도가 보이며, 좌측의 관광지를 클릭해서 계획을 세울수있다.
![그림2](https://github.com/ssafy9-finalproject/frontServer/assets/70370578/5ca72d58-22af-4f09-97b1-917e54efeefe)
 
- 	우측의 일자별 일정을 설정하고, 좌측의 관광지를 클릭하면, 날짜에따라 여행계획을 세울수있다.
![그림3](https://github.com/ssafy9-finalproject/frontServer/assets/70370578/e48e48dd-b74a-4a37-b2ce-5c27576f78f2)
- 	이렇게 완성된 일정은 하단에 타임라인을 통해 표시된다.<br>
![그림4](https://github.com/ssafy9-finalproject/frontServer/assets/70370578/457c9e61-376c-4909-b0f3-d56d2567460b) 

- 	마지막으로 사용자는 자신의 계획을 저장할수있는데, 제목, 내용을 입력하고 submit itinerary 버튼을 누르면된다.
![그림5](https://github.com/ssafy9-finalproject/frontServer/assets/70370578/f57ed985-42ff-4f04-bbc6-fb2fc1e2ed84) 

### 	리뷰
- 	리뷰는 Review 탭을 클릭해, 리뷰의 메인화면으로 접근할수있다.
- 	로그인 안한 유저는 이미 작성된 리뷰를 볼수있다.<br>
![그림6](https://github.com/ssafy9-finalproject/frontServer/assets/70370578/f90172e2-861d-4297-bb2c-90bec38dca50)
 


- 	하단의 Regist 버튼을 클릭하면, 작성된 여행계획들을 볼수있고, 작성했던 여행계획을 클릭해 리뷰를 작성할수있다.
 ![그림7](https://github.com/ssafy9-finalproject/frontServer/assets/70370578/07c3dc80-9ff7-4eb7-abb0-d40b8d20eec5)
 

- 	제목과 일차별 내용을 작성할수있고, 사진 첨부가 가능하다.
 ![그림8](https://github.com/ssafy9-finalproject/frontServer/assets/70370578/da3435f1-2279-44dc-96c4-ec42751d805b)
 ![그림9](https://github.com/ssafy9-finalproject/frontServer/assets/70370578/30d9b276-8cef-4e66-bc3f-822ffbd74a46)

 
- 	파일 첨부 방식은 리뷰를 작성하다가 중간에 파일을 넣을수있도록 만들었다. 해당 리뷰를 작성하다가 파일 첨부를 하면, 중간에 사진을 삽입할수있다.<br>
 ![그림10](https://github.com/ssafy9-finalproject/frontServer/assets/70370578/604c8f40-b117-4909-b81f-c5cc7a6dbf41)

 
- 	작성된 리뷰는 메인화면에 등록된다.<br>
 ![그림11](https://github.com/ssafy9-finalproject/frontServer/assets/70370578/2e68ff2a-cc48-4363-ae0e-42c4796efcd5)


 
- 	리뷰 조회 : 리뷰를 클릭하면 조회할수있다.<br>
 ![그림12](https://github.com/ssafy9-finalproject/frontServer/assets/70370578/a570e16c-232b-4987-9b63-5497261d9ea3)

 
- 	오른쪽 하단의 delete 버튼으로 삭제, Modify 버튼을 사용해 리뷰를 수정할수있다.<br>
 ![그림13](https://github.com/ssafy9-finalproject/frontServer/assets/70370578/5586a42f-b595-495f-9de3-f321bf8d6fc5)

 
- 	우측의 하트 모양을 클릭해서 해당 계획에 좋아요를 표시할수있다.<br>
 ![그림14](https://github.com/ssafy9-finalproject/frontServer/assets/70370578/01c81ceb-2ebe-4a0f-8454-da209859fcb2)

- 	마지막으로, 해당 리뷰는 로그인 한 유저에 한해서 댓글을 남길수있으며, 단순한 리뷰 감상은 로그인 하지않아도 가능하다.
- 	우측의 X 버튼을 클릭해 자신이 작성한 리뷰를 삭제할수있다.<br>
![그림15](https://github.com/ssafy9-finalproject/frontServer/assets/70370578/79643c48-79e4-4a4f-91c2-da341cbcc2b7)
 
 
### 	관리자: 유저 관리
- 	admin으로 로그인을 하면 우측 상단의 Admin을 통해 유저관리를 할수있다.<br>
 ![그림16](https://github.com/ssafy9-finalproject/frontServer/assets/70370578/cfb215a4-0e68-496e-8124-bbdc33042a02)

 
- 	admin으로 로그인을 하면 우측 상단의 Admin을 통해 유저관리를 할수있다.
- 	멤버의 상세정보인 아이디, 비밀번호, 기타 인적사항을 볼수있다.<br>
 ![그림17](https://github.com/ssafy9-finalproject/frontServer/assets/70370578/6ec020e1-49a9-45f8-8d6f-5d561ad4ae05)

 
- 	멤버 상세 정보: MemberId를 클릭하면 멤버의 상세정보를 볼수있다.<br>
 ![그림18](https://github.com/ssafy9-finalproject/frontServer/assets/70370578/1fb1dfd5-6182-4667-ac68-aabad02a5542)

 
- 	Memberlist에서 update 버튼을 클릭하면 멤버를 수정할수있고, delete를 통해 멤버를 삭제할수있다.<br>
 ![그림19](https://github.com/ssafy9-finalproject/frontServer/assets/70370578/1815e491-6924-4215-9576-a6db5316cbe0)

 
### 	유저: 마이페이지 수정
- 	유저는 admin 이외의 아이디이다. 유저로 로그인하면 마이페이지를 있고, 자신이 원하는 정보를 수정할수있다.<br>
![그림20](https://github.com/ssafy9-finalproject/frontServer/assets/70370578/464ca227-05c3-41f0-bb9d-a68884401f27)

 
## 3. API 명세서
 ![그림21](https://github.com/ssafy9-finalproject/frontServer/assets/70370578/d8ca0af6-dad9-454b-b8cc-21cdad71459d)


## 4.	데이터베이스 스키마
-	관광지 관련 : attraction_info, attraction_detail, attraction_description, sido, gugun,
-	계획 관련: plan
-	리뷰 관련: review, review_content, likes, comments
-	사용자: members
-	구현 못한부분: follow, scrap<br>
![그림22](https://github.com/ssafy9-finalproject/frontServer/assets/70370578/881e0419-3c36-48f0-8b41-f9b7e83c4702)<br>
![그림23](https://github.com/ssafy9-finalproject/frontServer/assets/70370578/27b68ee4-1148-4281-a6bf-6968ed010be3)<br>

 
## 5.	 클래스 다이어그램
-	여행계획, 유저, 리뷰 클래스 다이어그램<br>
 - plan<br>
![그림24](https://github.com/ssafy9-finalproject/frontServer/assets/70370578/c7c01c9c-4edb-4de2-ba05-aea5032914e3)

 - member<br>
![그림25](https://github.com/ssafy9-finalproject/frontServer/assets/70370578/4e8ccf14-7579-4caf-a397-68073ae5b368)
  
 - review<br>
![그림26](https://github.com/ssafy9-finalproject/frontServer/assets/70370578/67d7fa7a-7546-407e-bd74-99e74922cd93)
 



## 6.	시스템 아키텍쳐
 ![그림27](https://github.com/ssafy9-finalproject/frontServer/assets/70370578/83f920b5-f6f1-49b0-992a-0bb2759ba467)

 
## 7.예외처리
 ![그림28](https://github.com/ssafy9-finalproject/frontServer/assets/70370578/760ad1d3-4a3e-49c0-a36f-f9b2bc00c89c)

 
## 8.	의존성
### 	Eclipse
- 	Java 1.8
- 	Springboot 2.7.11
- 	Springboot
-  	  Spring-boot-starter-web
  	  Spring-boot-starter-validation
 	    Spring-boot-devtools
- 	Mybatis
-  	  Mybatis-spring-boot-starter 2.3.0
- 	Mysql
- 	  Mysql-connector-j
- 	Lombok
- 	Aws s3
- 	  Spring-cloud-starter-aws 2.2.6.RELEASE
- 	Swagger 
- 	  Springfox-boot-starter
- 	  Springfox-swagger-ui 3.0
- 	Jwt
- 	  Io.jsonwebtoken jjwt 0.9.1
### 	Visual Studio Code
- 	Axios 1.4.0
- 	Bootstrap
- 	    Bootstrap 5.2.3
 	    Bootstrap-icons 1.10.5
 	    Bootstrap-vue 2.23.1
- 	Core-js 3.8.3
- 	Jwt
- 	    Jwt-decode 3.1.2
- 	Vue
- 	    Vue 2.7.14
 	    Vue-router 3.5.1
- 	Vuex
- 	    Vuex 3.6.2
 	    Vuex-persistedstate 4.1.0
 
## 9.	Jwt 설정
### 	단계
- 	Jwt는 관리자가 회원을 관리할 때 사용하거나, 여행 계획을 세우고, 리뷰를 작성할 때 헤더에 항상 AccessToken과 refreshToken을 헤더에 담아 전송하고, 서버에서 항상 읽어서 유효한지 검사한다.<br>
 ![그림29](https://github.com/ssafy9-finalproject/frontServer/assets/70370578/3a5680b6-a676-44a5-802e-1bbc09eddf94)

 
- 	Jwt만료시 서버에서 생성하고 exception을 throw한다. vue에서 exception에 따라 응답 인터셉터로 처리한다.<br>
 ![그림30](https://github.com/ssafy9-finalproject/frontServer/assets/70370578/42244a6f-3156-4e0d-9574-a33185505f1e)

 
