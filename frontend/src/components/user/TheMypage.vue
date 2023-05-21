<template>
  <div class="view-content">
    <h3 class="app_title">마이 페이지</h3>
    <div class="wrap">
      <div class="MyPageWrap">
        <h3 class="profileHeader">프로필 정보</h3>
        <div class="profile">
          <div class="profile-image">
            <img src="@/assets/yoon.jpg" alt="프로필사진" class="profile" />
            <div class="FollowWrap">
              <span>게시글</span>
              <span>팔로워</span>
              <span>팔로잉</span>
            </div>
            <div class="FollowWrap1">
              <a @click="showPost">{{ posts.length }}개</a>
              <a @click="showFollower">{{ followerList.length }}명</a>
              <a @click="showFolloweeing">{{ followeeList.length }}명</a>
            </div>
          </div>
        </div>
        <div class="userinfoname">{{ user.name }}</div>
        <div class="userinfoemail">{{ user.email }}</div>
        <router-link to="#" class="modify">프로필 편집</router-link>
      </div>
      <div class="right-container" v-if="Post">
        <h3 class="boardTitle">게시글 목록</h3>
        <div v-if="posts.length == 0">작성한 게시글이 없습니다.</div>
        <div v-else>
          <div v-for="(post, index) in posts" :key="index">
            <div style="height: 100px"><board-post-item :board="post"></board-post-item></div>
          </div>
        </div>
      </div>
      <div class="right-container" v-else-if="Follower">
        <h3>팔로워 목록</h3>
        <div v-if="followerList.length == 0" class="nofollwer">
          팔로워가 없습니다.
          <div>여행 포스트를 추가해서 팔로워를 모아보세요!! 😊</div>
        </div>
        <div v-else>
          <div v-for="(follower, index) in followerList" :key="index">
            <div style="height: 100px">{{ follower }}</div>
          </div>
        </div>
        <!-- <ul>
          <li v-for="post in posts" :key="post.id">{{ post.title }}</li>
        </ul> -->
      </div>
      <div class="right-container" v-else-if="Followeeing">
        <h3>팔로잉 목록</h3>
        <div v-if="followeeList.length == 0" class="nofollwer">팔로잉이 없습니다.</div>
        <div v-else>
          <div v-for="(followee, index) in followeeList" :key="index">
            <div style="height: 100px">{{ followee }}</div>
          </div>
        </div>
        <!-- <ul>
          <li v-for="post in posts" :key="post.id">{{ post.title }}</li>
        </ul> -->
      </div>
    </div>
  </div>
</template>

<script>
import http from "@/api/http";
import { mapState } from "vuex";
import BoardPostItem from "@/components/board/BoardPostItem.vue";

export default {
  name: "MyPageView",
  components: {
    BoardPostItem,
  },
  computed: {
    ...mapState("userStore", ["userInfo"]),
  },
  data() {
    return {
      user: {
        no: 0,
        name: "",
        email: "",
      },
      Post: true,
      Follower: false,
      Followeeing: false,
      posts: [],
      followerList: [],
      followeeList: [],
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
    getUserInfo() {
      this.user.no = this.userInfo ? this.userInfo.userno : 0;
      //   console.log(this.user.no);
      http
        .get(`/board/mypage/${this.user.no}`)
        .then(({ data }) => {
          // console.log(data, "성공");
          this.posts = data;
        })
        .catch((error) => {
          console.log(error);
        });

      http
        .get(`/user/getfollowee/${this.user.no}`)
        .then(({ data }) => {
          this.followeeList = data.followeeList;
          //   console.log(this.followee, "안녕");
          //   console.log(data);
        })
        .catch((error) => {
          console.log(error);
        });

      http
        .get(`/user/getfollower/${this.user.no}`)
        .then(({ data }) => {
          //   console.log(this.user.no);
          //   console.log(data, "asdsjj");
          this.followerList = data.followerList;
          //   console.log(this.followerList, "asd");
          //   console.log(this.followerList.length, "asd");
        })
        .catch((error) => {
          console.log(error);
        });
      //   console.log("teset", this.followerList);
    },
  },
  created() {
    this.getUserInfo();
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
  margin: 30px 0px 0px 100px;
  text-align: left;
  padding: 0 20px;
  border-radius: 8px 8px 8px 8px;
}

.MyPageWrap {
  position: relative;
  border: 2px solid;
  width: 450px;
  margin-top: 30px;
  border-radius: 20px 20px 20px 20px;
  height: 280px;
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
  margin: 120px 0px 0px 160px;
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
a {
  cursor: pointer;
}
.boardTitle {
  text-align: center;
}
.nofollwer {
  font-size: 15pt;
  font-weight: bold;
}
</style>
