<template>
  <div>
    <input type="text" v-model="article.userno" disabled placeholder="김싸피" />
    <input type="text" v-model="article.title" placeholder="제목 입력..." />
    <input
      v-model="article.content"
      placeholder="내용 입력..."
      rows="10"
      max-rows="15"
    />
    <a @click="writeArticle">등록</a>
  </div>
</template>

<script>
import http from "@/api/http";

export default {
  name: "BoardWrite",
  data() {
    return {
      article: {
        userno: 1,
        title: "",
        content: "",
        scope: 0,
      },
    };
  },
  methods: {
    writeArticle() {
      http
        .post(`/board`, JSON.stringify(this.article))
        .then(({ data }) => {
          alert(data);
          this.$router.replace("/board");
        })
        .catch((error) => {
          console.log(error);
        });
    },
  },
};
</script>

<style></style>
