<template>
  <div>
    <div class="boardlist">
      <div class="container">
        <div class="fixed-section">
          <h3 class="app_title">커뮤니티</h3>
          <div v-if="this.userInfo">
            <label class="radio-button" :class="{ active: viewMode === 'all' }">
              <input
                type="radio"
                name="viewMode"
                value="all"
                v-model="viewMode"
                @change="changeViewMode"
              />
              <span>전체 보기</span>
            </label>
            <label
              class="radio-button"
              :class="{ active: viewMode === 'follow' }"
            >
              <input
                type="radio"
                name="viewMode"
                value="follow"
                v-model="viewMode"
                @change="changeViewMode"
              />
              <span>팔로우만 보기</span>
            </label>
          </div>
        </div>
        <div class="scrollable-section">
          <div v-if="boards.length == 0">
            <div class="post">비었습니다..!</div>
          </div>
          <div class="post" v-for="(board, index) in boards" :key="index">
            <div class="post-header">
              <div class="profile-image"></div>
              <div class="post-info">
                <div class="post-nickname">{{ board.nickname }}</div>
                <p class="post-date">{{ board.createdate }}</p>
              </div>
            </div>
            <div class="post-content">
              <h3>{{ board.title }}</h3>
              <p>{{ board.content }}</p>
            </div>
            <div class="post-footer">
              <div class="likes">
                <svg
                  v-if="board.islike === 0"
                  @click="toggleLikes(board)"
                  width="24"
                  height="24"
                  viewBox="0 0 24 24"
                  fill="none"
                  xmlns="http://www.w3.org/2000/svg"
                  class="pointer mr-6"
                >
                  <path
                    d="M6.15623 15.5418L6.1561 15.5416L6.156 15.5415L6.15594 15.5415L6.15076 15.5361L6.14515 15.5306C2.9755 12.4253 2.6 9.82916 2.6 8.13045C2.6 7.36994 2.97794 6.22033 3.78099 5.26092C4.56853 4.32004 5.73192 3.6 7.29118 3.6C8.65775 3.6 9.70139 4.19196 10.4186 4.80541C10.7769 5.11188 11.0476 5.41888 11.2276 5.64793C11.3173 5.76209 11.3837 5.85586 11.4265 5.91907C11.4478 5.95064 11.4632 5.97449 11.4726 5.98933L11.4821 6.00463L11.4829 6.00579L11.4831 6.00613L11.4834 6.00662L11.4835 6.00689L11.9984 6.87343L12.5133 6.00689L12.5135 6.00662L12.5135 6.00659L12.5138 6.00613L12.514 6.00579L12.5147 6.00463L12.5243 5.98933C12.5337 5.97449 12.549 5.95064 12.5704 5.91907C12.6131 5.85587 12.6795 5.7621 12.7693 5.64794C12.9493 5.41889 13.2199 5.1119 13.5783 4.80543C14.2956 4.19199 15.3393 3.6 16.7062 3.6C18.2652 3.6 19.4293 4.32008 20.2177 5.26111C21.0215 6.22065 21.4 7.37022 21.4 8.13045C21.4 9.82884 21.0216 12.4272 17.8518 15.5305L17.8462 15.5361L17.8409 15.5415L17.8408 15.5415L17.8408 15.5416L17.8406 15.5418L17.8405 15.5419L17.8378 15.5447L17.8241 15.5586C17.8113 15.5714 17.7913 15.5915 17.7637 15.6186C17.7086 15.6729 17.6235 15.7554 17.5068 15.865C17.2733 16.0842 16.9135 16.4118 16.4146 16.8384C15.4699 17.6461 14.0265 18.8089 11.9984 20.263C9.97032 18.8089 8.52694 17.6461 7.58225 16.8384C7.08337 16.4118 6.72354 16.0842 6.4901 15.865C6.37338 15.7554 6.28825 15.6729 6.23314 15.6186C6.20558 15.5915 6.18552 15.5714 6.17277 15.5586L6.1591 15.5447L6.15632 15.5419L6.15623 15.5418Z"
                    stroke="#16191D"
                    stroke-width="1.2"
                  ></path>
                </svg>
                <svg
                  v-else
                  @click="toggleLikes(board)"
                  width="24"
                  height="24"
                  viewBox="0 0 24 24"
                  fill="none"
                  xmlns="http://www.w3.org/2000/svg"
                  class="pointer mr-6"
                >
                  <path
                    d="M6.15623 15.5418L6.1561 15.5416L6.156 15.5415L6.15594 15.5415L6.15076 15.5361L6.14515 15.5306C2.9755 12.4253 2.6 9.82916 2.6 8.13045C2.6 7.36994 2.97794 6.22033 3.78099 5.26092C4.56853 4.32004 5.73192 3.6 7.29118 3.6C8.65775 3.6 9.70139 4.19196 10.4186 4.80541C10.7769 5.11188 11.0476 5.41888 11.2276 5.64793C11.3173 5.76209 11.3837 5.85586 11.4265 5.91907C11.4478 5.95064 11.4632 5.97449 11.4726 5.98933L11.4821 6.00463L11.4829 6.00579L11.4831 6.00613L11.4834 6.00662L11.4835 6.00689L11.9984 6.87343L12.5133 6.00689L12.5135 6.00662L12.5135 6.00659L12.5138 6.00613L12.514 6.00579L12.5147 6.00463L12.5243 5.98933C12.5337 5.97449 12.549 5.95064 12.5704 5.91907C12.6131 5.85587 12.6795 5.7621 12.7693 5.64794C12.9493 5.41889 13.2199 5.1119 13.5783 4.80543C14.2956 4.19199 15.3393 3.6 16.7062 3.6C18.2652 3.6 19.4293 4.32008 20.2177 5.26111C21.0215 6.22065 21.4 7.37022 21.4 8.13045C21.4 9.82884 21.0216 12.4272 17.8518 15.5305L17.8462 15.5361L17.8409 15.5415L17.8408 15.5415L17.8408 15.5416L17.8406 15.5418L17.8405 15.5419L17.8378 15.5447L17.8241 15.5586C17.8113 15.5714 17.7913 15.5915 17.7637 15.6186C17.7086 15.6729 17.6235 15.7554 17.5068 15.865C17.2733 16.0842 16.9135 16.4118 16.4146 16.8384C15.4699 17.6461 14.0265 18.8089 11.9984 20.263C9.97032 18.8089 8.52694 17.6461 7.58225 16.8384C7.08337 16.4118 6.72354 16.0842 6.4901 15.865C6.37338 15.7554 6.28825 15.6729 6.23314 15.6186C6.20558 15.5915 6.18552 15.5714 6.17277 15.5586L6.1591 15.5447L6.15632 15.5419L6.15623 15.5418Z"
                    stroke="#d1190b"
                    stroke-width="1.2"
                    fill="#d1180b"
                  ></path>
                </svg>
                <span class="likes-count">
                  {{ board.cntLike }}
                </span>
              </div>
              <div class="comments">
                <svg
                  width="24"
                  height="24"
                  viewBox="0 0 24 24"
                  fill="none"
                  xmlns="http://www.w3.org/2000/svg"
                  class="pointer"
                >
                  <path
                    d="M5.34728 20.4531C4.68635 20.7697 4.00162 20.8711 3.41289 20.8773C2.75011 20.8842 2.58956 20.0714 2.90044 19.486C3.68666 18.0056 2.85777 16.4303 2.85777 16.4303M5.34728 20.4531C5.34728 20.4531 6.75 19.56 8.29418 20.424M5.34728 20.4531L5.0881 19.912C5.07977 19.916 5.07144 19.9199 5.06309 19.9238M5.34728 20.4531C5.02504 19.947 5.02528 19.9468 5.02552 19.9467L5.02603 19.9463L5.02716 19.9456L5.02982 19.944L5.03673 19.9397L5.05686 19.9275C5.05886 19.9263 5.06093 19.9251 5.06309 19.9238M8.29418 20.424C8.39735 20.4575 8.50202 20.4901 8.6067 20.5206M8.29418 20.424L8.58717 19.9004C8.56891 19.8902 8.55067 19.8802 8.53245 19.8704M8.29418 20.424L8.47904 19.8532C8.49686 19.859 8.51466 19.8647 8.53245 19.8704M8.6067 20.5206H8.61201C9.71046 20.8401 10.8524 21.0017 12.0004 21C17.7994 21 22.5 16.9713 22.5 12.0022C22.5 7.033 17.7986 3 11.9996 3C6.20291 3 1.5 7.0301 1.5 12M8.6067 20.5206L8.61201 20.5024L8.77456 19.9446C8.74775 19.9368 8.72085 19.9288 8.69386 19.9206M8.6067 20.5206V19.9206H8.61201H8.69386M1.5 12C1.50238 13.5705 1.97347 15.1076 2.85777 16.4303M1.5 12H2.1C2.1 11.9998 2.1 11.9997 2.1 11.9996M1.5 12L2.1 11.9991C2.1 11.9992 2.1 11.9994 2.1 11.9996M2.85777 16.4303C3.38875 16.1509 3.38886 16.1511 3.38898 16.1513L3.38922 16.1518L3.38976 16.1528L3.39106 16.1553L3.39454 16.1621L3.40482 16.1825C3.41306 16.1992 3.424 16.2219 3.43702 16.2502C3.46302 16.3068 3.49748 16.3862 3.53531 16.4849C3.61066 16.6816 3.7011 16.9599 3.76359 17.292C3.88768 17.9514 3.90879 18.8665 3.43035 19.7674C3.34151 19.9347 3.33241 20.1205 3.36539 20.2285C3.37341 20.2548 3.38157 20.2694 3.38629 20.2763M2.85777 16.4303L3.38875 16.1509L3.37408 16.123L3.35657 16.0968C2.53725 14.8713 2.10229 13.4498 2.1 11.9996M3.38629 20.2763C3.39059 20.2769 3.39715 20.2774 3.40659 20.2773C3.92665 20.2718 4.50959 20.1833 5.06309 19.9238M3.38629 20.2763C3.38398 20.276 3.38232 20.2757 3.38122 20.2754M3.38629 20.2763C3.39023 20.2821 3.39177 20.2826 3.38883 20.2802C3.38558 20.2776 3.38287 20.2761 3.38122 20.2754M2.1 11.9996C2.10028 7.44469 6.44432 3.6 11.9996 3.6C17.5571 3.6 21.9 7.44761 21.9 12.0022C21.9 16.5564 17.5582 20.4 12.0004 20.4L11.9995 20.4C10.9083 20.4016 9.8231 20.248 8.77958 19.9445L8.6975 19.9206H8.69386M8.69386 19.9206C8.64033 19.9045 8.58648 19.8877 8.53245 19.8704M8.53245 19.8704C7.6232 19.3811 6.75271 19.3929 6.11723 19.5276C5.795 19.5959 5.53012 19.6961 5.3438 19.7802C5.25026 19.8224 5.17535 19.861 5.12163 19.8906C5.09805 19.9035 5.07846 19.9148 5.06309 19.9238M3.38122 20.2754C3.37997 20.2751 3.37944 20.2749 3.37949 20.2749L3.38122 20.2754Z"
                    stroke="#16191D"
                    stroke-width="0.7"
                  ></path>
                </svg>
                <span class="comments-count">{{ board.cntReply }}</span>
              </div>
            </div>
          </div>
        </div>
        <div class="fixed-section right-section">
          <h3>베스트 게시물</h3>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import http from "@/api/http";
import { mapState } from "vuex";
import { onlyAuthUser } from "@/api/logincheck";

export default {
  name: "BoardList",
  components: {},
  computed: {
    ...mapState("userStore", ["userInfo"]),
  },
  data() {
    return {
      viewMode: "all",
      isFollowSelect: 0,
      boards: [],
    };
  },
  created() {
    this.getBoard();
  },
  methods: {
    getBoard() {
      this.boards = [];
      const boardInfo = {
        isFollowSelect: this.isFollowSelect,
        userno: this.userInfo ? this.userInfo.userno : 0,
      };
      http
        .post(`/board`, JSON.stringify(boardInfo))
        .then(({ data }) => {
          // console.log(data);
          this.boards = data;
        })
        .catch((error) => {
          console.log(error);
        });
    },
    toggleLikes(board) {
      onlyAuthUser();
      if (this.userInfo === null) return;

      let likesInfo = {
        boardno: board.boardno,
        userno: this.userInfo.userno,
      };

      if (board.islike === 0) {
        http
          .post(`/board/addlikes`, JSON.stringify(likesInfo))
          .then(({ data }) => {
            if (data === "success") {
              board.islike = 1;
              board.cntLike += 1;
            }
          })
          .catch((error) => {
            console.log(error);
          });
      } else {
        http
          .post(`/board/deletelikes/`, JSON.stringify(likesInfo))
          .then(({ data }) => {
            if (data === "success") {
              board.islike = 0;
              board.cntLike -= 1;
            }
          })
          .catch((error) => {
            console.log(error);
          });
      }
    },
    changeViewMode() {
      this.isFollowSelect = this.isFollowSelect == 0 ? 1 : 0;
      this.getBoard();
    },
  },
};
</script>

<style scoped>
.container {
  display: flex;
  overflow: auto;
}

.fixed-section {
  position: fixed;
  /* flex-shrink: 0; */
  width: 240px;
  height: calc(100vh - 70px);
}

.scrollable-section {
  width: 680px;
  margin: 0 240px;
  padding: 0 100px;
  padding-top: 40px;
}

.right-section {
  padding-top: 20px;
  margin-left: calc(240px + 680px);
}

.post {
  border-radius: 10px;
  border: 1px solid #e5e7eb;
  padding: 20px;
  margin-bottom: 60px;
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
  margin-right: 15px;
}

.post-info {
  flex-grow: 1;
}

.post-nickname {
  font-size: 16px;
  font-weight: 500;
  margin: 0;
}

.post-date {
  color: #888;
  margin: 4px 0 0 0;
  font-size: 14px;
  font-weight: 500;
}

.post-content {
  margin-top: 10px;
}

.post-footer {
  display: flex;
  align-items: center;
  margin-top: 25px;
}

.likes,
.comments {
  display: flex;
  align-items: center;
  margin-right: 10px;
  width: 50px;
}

svg {
  cursor: pointer;
}
/* 
.click-animation {
  animation: clickEffect 0.1s linear forwards;
}

@keyframes clickEffect {
  0% {
    opacity: 1;
    transform: scale(1);
  }
  100% {
    opacity: 0;
    transform: scale(1.5);
  }
} */

.likes-count,
.comments-count {
  margin-left: 5px;
  margin-right: 10px;
  font-size: 14px;
}

.radio-button {
  display: inline-flex;
  align-items: center;
  border-radius: 9999px;
  padding: 10px 16px;
  background-color: #fff;
  color: #555;
  cursor: pointer;
  border: 1px solid #ccc;
  margin-right: 10px;
  /* transition: border-color 0.3s ease; */
}

.radio-button.active {
  border-color: #2979ff;
}

.radio-button input[type="radio"] {
  display: none;
}

.radio-button input[type="radio"]:checked + span {
  color: #2979ff;
}

.radio-button input[type="radio"]:checked + span:before {
  background-color: #2979ff;
}

.radio-button input[type="radio"]:focus + span {
  outline: none;
}

.radio-button input[type="radio"]:focus + span:before {
  box-shadow: 0 0 3px rgb(0, 96, 255);
}
</style>
