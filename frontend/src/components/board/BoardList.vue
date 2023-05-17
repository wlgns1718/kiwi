<template>
  <div>
    <h2>게시판 목록</h2>
    <div class="boardlist">
      <table>
        <tr v-for="board in boards" :key="board.articleno">
          <td>{{ board.articleno }}</td>
          <td>{{ board.userid }}</td>
          <td>
            <router-link to="/board/detail">{{ board.subject }}</router-link>
          </td>
          <td>{{ board.content }}</td>
          <td>{{ board.hit }}</td>
          <td>{{ board.regtime }}</td>
        </tr>
      </table>
    </div>
  </div>
</template>

<script>
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
      ],
    };
  },
  created() {},
  methods: {},
};
</script>

<style scoped>
table {
  border-collapse: collapse;
}
td {
  border-bottom: 1px solid;
}
tr:nth-child(even) {
  background-color: #f2f2f2;
}
h2 {
  display: flex;
  justify-content: center;
}
.boardlist {
  display: flex;
  justify-content: center;
  width: 100%;
}
tr {
  height: 70px;
  width: 100%;
}
</style>