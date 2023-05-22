<template>
  <div style="comment-wrap">
    <div class="comment-form">
      <input type="text" v-model="replyMsg" placeholder="댓글을 입력하세요" />
      <button @click="sendReplyMsg">
        <div class="send-icon">
          <svg
            xmlns="http://www.w3.org/2000/svg"
            viewBox="0 0 24 24"
            fill="none"
            stroke="currentColor"
            stroke-width="2"
            stroke-linecap="round"
            stroke-linejoin="round"
            class="feather feather-send"
          >
            <line x1="22" y1="2" x2="11" y2="13"></line>
            <polygon points="22 2 15 22 11 13 2 9 22 2"></polygon>
          </svg>
        </div>
      </button>
    </div>
    <div class="comment" v-if="replys.length != 0">
      <div class="comment-each" v-for="(reply, index) in replys" :key="index">
        <div class="header">
          <div>
            <span class="nickname" style="padding-right: 10px">{{ reply.nickname }}</span>
            <span
              v-if="reply.nickname == userInfo.nickname"
              class="date"
              style="padding-right: 10px"
              >수정</span
            >
            <span v-if="reply.nickname == userInfo.nickname" class="date">삭제</span>
          </div>
          <div class="date">
            <span>{{ reply.createdate }}</span>
            <span>신고</span>
          </div>
        </div>
        <div class="content">
          <p>
            {{ reply.content }}
          </p>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import http from "@/api/http";
import { mapState } from "vuex";

export default {
  name: "BoardReplyItem",
  components: {},
  props: ["boardno"],
  computed: {
    ...mapState("userStore", ["userInfo"]),
  },
  data() {
    return {
      replyMsg: "",
      replys: [],
      replyInfo: {},
    };
  },
  created() {
    this.replyInfo = {
      boardno: this.$route.params.no,
      userno: this.userInfo.userno,
    };
    this.getReplys();
  },
  methods: {
    getReplys() {
      http.get(`/reply/${this.replyInfo.boardno}`).then(({ data }) => {
        // console.log(data);
        this.replys = data;
      });
    },
    sendReplyMsg() {
      const writeInfo = { ...this.replyInfo, content: this.replyMsg };
      http.post(`/reply/write`, JSON.stringify(writeInfo)).then(({ data }) => {
        if (data === "success") {
          this.getReplys();
        }
      });
      this.replyMsg = "";
    },
  },
};
</script>

<style scoped>
.comment {
  display: flex;
  flex-direction: column;
  border: 1px solid #e5e7eb;
  border-radius: 10px;
  padding: 20px;
}

.comment-form {
  display: flex;
  align-items: center;
  border: 1px solid #e5e7eb;
  border-radius: 10px;
  margin-bottom: 10px;
}

.comment-form input[type="text"] {
  flex: 1;
  padding: 8px;
  border: 1px solid #ffffff;
  border-radius: 4px;
}

.comment-form button {
  padding: 8px;
  background-color: transparent;
  border: none;
  cursor: pointer;
}

.comment-form .send-icon {
  margin-top: 2px;
}

.comment-form svg {
  width: 20px;
  height: 20px;
  stroke: #cccccc;
  fill: none;
}

.comment-each {
  margin-bottom: 30px;
}

.comment-each:last-child {
  margin-bottom: 0;
}

.header {
  display: flex;
  align-items: center;
  justify-content: space-between;
  margin-bottom: 5px;
}

.nickname {
  font-weight: bold;
}

.date {
  font-size: 12px;
  color: gray;
}

.date span {
  padding-left: 10px;
}

.content {
  flex: 1;
}

p {
  margin: 0;
}
</style>
