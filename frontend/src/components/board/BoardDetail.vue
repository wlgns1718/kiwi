<template>
  <div>
    <div>
      {{ board.boardno }}
      {{ board.content }}
      {{ board.createdate }}
      {{ board.hit }}
      {{ board.scope }}
      {{ board.title }}
      {{ board.userno }}
    </div>
    <div>수정</div>
    <div @click="deleteBoard">삭제</div>
  </div>
</template>

<script>
import http from "@/api/http";

export default {
  name: "BoardDetail",
  components: {},
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
  methods: {},
};
</script>

<style scoped></style>
