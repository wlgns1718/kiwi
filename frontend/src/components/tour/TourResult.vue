<template>
  <div class="result-wrap">
    <div class="item" v-for="(tour, index) in tours" :key="index">
      <div width="150px">
        <img v-if="tour.firstImage !== ''" :src="tour.firstImage" />
        <img v-else-if="tour.firstImage2 !== ''" :src="tour.firstImage2" />
        <img v-else src="@/assets/default.png" />
      </div>
      <div class="item-detail">
        <div class="title-wrap">
          <div class="title">{{ tour.title }}</div>
          <div>{{ tour.addr1 }}</div>
        </div>
        <div class="overview">
          <p v-if="tour.overview != null && tour.expanded">{{ tour.overview }}</p>
          <p v-else>{{ tour.overview != null && tour.overview.substring(0, 100) }} ...</p>
          <button class="moreBtn" @click="toggleExpansion(tour)">
            {{ tour.expanded ? "접기" : "더보기" }}
          </button>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { mapState } from "vuex";

export default {
  name: "TourResult",
  components: {},
  computed: {
    ...mapState(["tours"]),
  },
  data() {
    return {
      message: "",
    };
  },
  created() {},
  methods: {
    toggleExpansion(item) {
      item.expanded = !item.expanded;
    },
  },
};
</script>

<style scoped>
.result-wrap {
  border-radius: 12px;
  padding: 10px 20px;
  /* border: 2px solid var(--colorFg16); */
  background: #f9f9f9;
  height: 483px;
  width: calc(1200px - 560px);
  overflow-y: auto;
}

.item {
  border-radius: 12px;
  background: white;
  padding: 20px;
  margin: 10px 0;
  display: flex;
}

img {
  width: 150px;
  height: 150px;
}

.item-detail {
  padding-left: 25px;
}

.title-wrap {
  /* display: flex; */
  font-size: 14px;
  padding-bottom: 20px;
}

.title {
  font-size: 22px;
  font-weight: bold;
  padding-top: 6px;
}

p {
  margin: 0;
}
.moreBtn {
  float: right;
  background: #eee;
  border: 0;
  /* border-radius: 14px; */
}

.result-wrap::-webkit-scrollbar {
  width: 8px;
}

.result-wrap::-webkit-scrollbar-thumb {
  background-color: #dddddd;
  border-radius: 12px;
}

.result-wrap::-webkit-scrollbar-track {
  background-color: #f9f9f9;
  border-radius: 12px;
}
</style>
