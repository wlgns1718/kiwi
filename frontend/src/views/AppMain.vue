<template>
  <div class="main-content">
    <div class="weather" v-if="this.weather !== null">
      {{ weather.name }}
      <img :src="weatherImgSrc" style="width: 40px" />
      {{ parseInt(weather.main.temp - 273.15) }} ℃
    </div>
    <main-image-swiper></main-image-swiper>
    <div id="intro">
      <div id="intro-top">안녕하세요 &#128400;</div>
      <div id="intro-img">
        <img src="/assets/earch.PNG" alt="" />
      </div>
      <p id="intro-text">저희와 함께 여행을 떠나볼까요?</p>
    </div>
  </div>
</template>

<script>
import MainImageSwiper from "@/components/main/MainImageSwiper.vue";
import axios from "axios";
import { mapActions } from "vuex";

export default {
  name: "AppMain",
  components: {
    MainImageSwiper,
  },
  created() {
    this.navToggle(this.$route.path);
    this.loadWeather();
  },
  methods: {
    ...mapActions("headerStore", ["navToggle"]),
    loadWeather() {
      // 위치 정보 가져오기
      navigator.geolocation.getCurrentPosition(
        (position) => {
          const latitude = position.coords.latitude;
          const longitude = position.coords.longitude;

          // 날씨 API 호출
          axios
            .get(
              `https://api.openweathermap.org/data/2.5/weather?lat=${latitude}&lon=${longitude}&appid=5efbc6e88a0abdec1b22df8318e29b34`
            )
            .then(({ data }) => {
              console.log(data);
              this.weather = data;
              this.weatherImgSrc = `http://openweathermap.org/img/w/${data.weather[0].icon}.png`;
              // this.weather = response.main.weather[0].description;
            })
            .catch((error) => {
              console.error(error);
            });
        },
        (error) => {
          console.error(error);
        }
      );
    },
  },
  data() {
    return {
      weather: null,
      weatherImgSrc: "",
    };
  },
};
</script>

<style scope>
.main-content {
  width: 1200px;
  margin: 0 auto;
  margin-top: 50px;
}

.weather {
  display: flex;
  align-items: center;
}

#intro {
  transition: 0.2s;
  margin: 36px 0px;
  padding: 30px 66px 30px 66px;
  border-radius: 30px;
  border-radius: 14px;
  box-shadow: 2px 5px 40px 0 rgba(0, 0, 0, 0.08);
  text-align: center;
}

#intro:hover {
  box-shadow: 3px 6px 44px 0 rgba(0, 0, 0, 0.18);
  transform: scale(1.01);
}

#intro-top {
  font-size: 60px;
  font-weight: 600;
}

#intro-text {
  font-size: 40px;
  margin: 0;
}

#intro-img {
  transition: 0.5s;
}

#intro-img:hover {
  transform: scale(1.1);
}
</style>
