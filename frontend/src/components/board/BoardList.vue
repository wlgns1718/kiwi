<template>
  <div>
    <div class="boardlist">
      <div class="container">
        <div class="section">
          <!-- 첫 번째 섹션 내용 -->
        </div>
        <div class="scrollable-section">
          <div class="post" v-for="(board, index) in boards" :key="index">
            <div class="post-header">
              <div class="profile-image"></div>
              <div class="post-info">
                <h2 class="post-title">{{ board.subject }}</h2>
                <p class="post-date">{{ board.regtime }}</p>
              </div>
            </div>
            <div class="post-content">
              <p>게시글 내용</p>
            </div>
            <div class="post-footer">
              <div class="likes">
                <img src="like-icon.png" alt="좋아요 아이콘" />
                
                <span class="likes-count">{{ board.hit }}</span>
              </div>
              <div class="comments">
                <img src="comment-icon.png" alt="댓글 아이콘" />
                <span class="comments-count">{{ board.hit }}</span>
              </div>
            </div>
          </div>
        </div>
        <div class="section">
          <!-- 세 번째 섹션 내용 -->
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import http from "@/api/http";

export default {
  name: "BoardList",
  components: {},
  data() {
    return {
      boards: [
        {
          articleno: 5,
          userid: "ssafy",
          subject: "글작성",
          content: "글작성",
          hit: 6,
          regtime: "10:55:19",
        },
        {
          articleno: 4,
          userid: "ssafy",
          subject: "프론트엔드 프레임워크",
          content: "Vue는 프론트엔드의 인기있는 프레임워크 입니다.",
          hit: 4,
          regtime: "10:53:50",
        },
        {
          articleno: 3,
          userid: "admin",
          subject: "뷰와 스프링부트를 이용한 실전 프로젝트",
          content: "프로젝트를 직접만드는 내용.",
          hit: 0,
          regtime: "10:53:50",
        },
        {
          articleno: 2,
          userid: "ssafy",
          subject: "Vue를 배워봅시다",
          content: "Vue와 Spring을 연동하자~",
          hit: 0,
          regtime: "10:53:50",
        },
        {
          articleno: 1,
          userid: "ssafy",
          subject: "Vue Axios 연동",
          content: "Vue를 이용한 HTTP 통신",
          hit: 0,
          regtime: "10:53:50",
        },
        {
          articleno: 1,
          userid: "ssafy",
          subject: "Vue Axios 연동",
          content: "Vue를 이용한 HTTP 통신",
          hit: 0,
          regtime: "10:53:50",
        },
        {
          articleno: 1,
          userid: "ssafy",
          subject: "Vue Axios 연동",
          content: "Vue를 이용한 HTTP 통신",
          hit: 0,
          regtime: "10:53:50",
        },
        {
          articleno: 1,
          userid: "ssafy",
          subject: "Vue Axios 연동",
          content: "Vue를 이용한 HTTP 통신",
          hit: 0,
          regtime: "10:53:50",
        },
      ],
    };
  },
  created() {
    this.getBoard();
  },
  methods: {
    getBoard() {
      http
        .get(`/board`)
        .then(({ data }) => {
          console.log(data);
          this.boards = data;
        })
        .catch((error) => {
          console.log(error);
        });
    },
  },
};
</script>

<style scoped>
.container {
  display: flex;
  height: 100vh;
}

.section {
  flex: 1;
  padding: 20px;
}

.scrollable-section {
  flex: 1;
  overflow-x: auto;
}

.scrollable-content {
  display: flex;
}
.post {
  border-radius: 10px;
  background-color: #eeeeee;
  padding: 10px;
  margin-bottom: 20px;
}

.post-header {
  display: flex;
  align-items: center;
}

.profile-image {
  width: 40px;
  height: 40px;
  border-radius: 50%;
  background-color: #ccc;
  margin-right: 10px;
}

.post-info {
  flex-grow: 1;
}

.post-title {
  font-size: 18px;
  margin: 0;
}

.post-date {
  color: #888;
  margin: 0;
}

.post-content {
  margin-top: 10px;
}

.post-footer {
  display: flex;
  align-items: center;
  margin-top: 10px;
}

.likes,
.comments {
  display: flex;
  align-items: center;
  margin-right: 10px;
}

.likes img,
.comments img {
  width: 20px;
  height: 20px;
  margin-right: 5px;
}

.likes-count,
.comments-count {
  font-size: 14px;
}
</style>
