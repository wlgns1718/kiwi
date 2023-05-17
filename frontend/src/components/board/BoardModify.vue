<template>
  <div>
    <div>게시글 번호 : {{ board.boardno }}</div>
    <input type="text" v-model="board.title" />
    <input type="text" v-model="board.content" />
    <a @click="modify">수정</a>
  </div>
</template>

<script>
import http from "@/api/http";

export default {
  data() {
    return {
      board: {
        boardno: "",
        content: "",
        createdate: "",
        hit: "",
        scope: "",
        title: "",
        userno: "",
      },
    };
  },

  created() {
    http.get(`/board/${this.$route.params.no}`).then(({ data }) => {
      console.log(data);
      this.board = data;
    });
  },
  methods: {
    modify() {
      http
        .put(`/board`, JSON.stringify(this.board))
        .then(({ data }) => {
          alert(data);
          this.$router.replace("/board/list");
        })
        .catch((error) => {
          console.log(error);
        });
    },
  },
};
</script>

<style scoped>
a {
  cursor: pointer;
}
</style>
