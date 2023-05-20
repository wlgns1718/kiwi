<template>
  <div class="view-content">
    <h3 class="app_title">마이 페이지</h3>
    <hr />
    <div class="wrap">
      <div class="MyPageWrap">
        <h3 class="profileHeader">프로필 정보</h3>
        <div class="profile">
          <div class="profile-image">
            <img src="@/assets/yoon.jpg" alt="프로필사진" class="profile" />
            <div class="FollowWrap">
              <span>게시글</span>
              <span>팔로우</span>
              <span>팔로잉</span>
            </div>
            <div class="FollowWrap1">
              <button @click="showPost">1개</button>
              <button @click="showFollower">2명</button>
              <button @click="showFolloweeing">2명</button>
            </div>
          </div>
        </div>
        <div class="userinfoname">{{ user.name }}</div>
        <div class="userinfoemail">{{ user.email }}</div>
        <router-link to="#" class="modify">프로필 편집</router-link>
      </div>
      <div class="right-container" v-if="Post">
        <h3>게시글 목록</h3>
        <div style="height: 100px">test</div>
        <div style="height: 100px">test</div>
        <div style="height: 100px">test</div>
        <div style="height: 100px">test</div>
        <div style="height: 100px">test</div>
        <div style="height: 100px">test</div>
        <div style="height: 100px">test</div>
        <!-- <ul>
          <li v-for="post in posts" :key="post.id">{{ post.title }}</li>
        </ul> -->
      </div>
      <div class="right-container" v-else-if="Follower">
        <h3>팔로우 목록</h3>
        <div style="height: 100px">test</div>
        <div style="height: 100px">test</div>
        <div style="height: 100px">test</div>
        <div style="height: 100px">test</div>
        <div style="height: 100px">test</div>
        <div style="height: 100px">test</div>
        <div style="height: 100px">test</div>
        <!-- <ul>
          <li v-for="post in posts" :key="post.id">{{ post.title }}</li>
        </ul> -->
      </div>
      <div class="right-container" v-else-if="Followeeing">
        <h3>팔로잉 목록</h3>
        <div style="height: 100px">test</div>
        <div style="height: 100px">test</div>
        <div style="height: 100px">test</div>
        <div style="height: 100px">test</div>
        <div style="height: 100px">test</div>
        <div style="height: 100px">test</div>
        <div style="height: 100px">test</div>
        <!-- <ul>
          <li v-for="post in posts" :key="post.id">{{ post.title }}</li>
        </ul> -->
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "MyPageView",
  components: {},
  data() {
    return {
      user: {
        name: "윤우혁",
        email: "square@naver.com",
      },
      Post: false,
      Follower: false,
      Followeeing: false,
      posts: [
        { id: 1, title: "첫 번째 게시글" },
        { id: 2, title: "두 번째 게시글" },
        { id: 3, title: "세 번째 게시글" },
      ],
    };
  },
  methods: {
    showPost() {
      this.Post = true;
      this.Follower = false;
      this.Followeeing = false;
      console.log(this.Post);
    },
    showFollower() {
      this.Post = false;
      this.Follower = true;
      this.Followeeing = false;
      console.log(this.Post);
    },
    showFolloweeing() {
      this.Post = false;
      this.Follower = false;
      this.Followeeing = true;
      console.log(this.Post);
    },
  },
};
</script>

<style scoped>
.wrap {
  display: flex;
}

.right-container {
  background-color: rgb(233, 231, 231);
  width: 500px;
  height: 500px;
  overflow: auto;
  margin: 30px 0px 0px 40px;
}

.MyPageWrap {
  position: relative;
  border: 2px solid;
  width: 450px;
  margin-top: 30px;
  border-radius: 20px 20px 20px 20px;
  height: 240px;
}
.FollowWrap {
  border: 1px solid;
  width: 265px;
  margin-left: 10px;
  border-radius: 6px 6px 6px 6px;
  display: flex;
  justify-content: space-between;
  font-size: 15pt;
  font-weight: bold;
  border-color: rgb(255, 255, 255);
}
.FollowWrap1 {
  position: absolute;
  top: 40px;
  border: 1px solid;
  width: 258px;
  margin: 90px 0px 0px 160px;
  border-radius: 6px 6px 6px 6px;
  display: flex;
  justify-content: space-between;
  font-size: 15pt;
  font-weight: bold;
  border-color: rgb(255, 255, 255);
}
.profile {
  margin: 0;
  width: 150px;
  height: 150px;
  border: 1px solid rgb(255, 255, 255);
  border-radius: 50%;
  display: flex;
  align-items: center;
  justify-content: space-between;
}
.profile-image {
  display: flex;
  align-items: center; /* 수직 가운데 정렬 */
  justify-content: space-between; /* 가로로 분산 정렬 */
}
.profileHeader {
  align-content: center;
}
.userinfoname {
  position: absolute;
  margin-top: 15px;
  margin-left: 20px;
  font-weight: bold;
}
.userinfoemail {
  position: absolute;
  margin-top: 35px;
  margin-left: 20px;
  font-weight: bold;
}
.modify {
  width: 270px;
  margin: 30px 0px 0px 155px;
  float: left;
  border-radius: 10px 10px 10px 10px;
}

.board-lists {
  background-color: red;
}
</style>
