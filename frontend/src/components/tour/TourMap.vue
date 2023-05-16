<template>
  <div class="map-wrapper">
    <div id="map"></div>
    <div class="result"></div>
  </div>
</template>

<script>
export default {
  name: "TourMap",
  components: {},
  data() {
    return {
      map: null,
    };
  },
  created() {},
  mounted() {
    if (window.kakao && window.kakao.maps) {
      // 카카오 객체가 있고, 카카오 맵그릴 준비가 되어 있다면 맵 실행
      this.loadMap();
    } else {
      // 없다면 카카오 스크립트 추가 후 맵 실행
      this.loadScript();
    }
  },
  methods: {
    // api 불러오기
    loadScript() {
      const script = document.createElement("script");
      script.src = `//dapi.kakao.com/v2/maps/sdk.js?libraries=services,clusterer,drawing&autoload=false&appkey=${process.env.VUE_APP_KAKAOMAP_KEY}`;
      script.onload = () => window.kakao.maps.load(this.loadMap);

      document.head.appendChild(script);
    },
    // 맵 출력하기
    loadMap() {
      const container = document.getElementById("map");
      const options = {
        center: new window.kakao.maps.LatLng(33.450701, 126.570667),
        level: 3,
      };

      this.map = new window.kakao.maps.Map(container, options);
      this.loadMaker();
    },
    // 지정한 위치에 마커 불러오기
    loadMaker() {
      const markerPosition = new window.kakao.maps.LatLng(
        33.450701,
        126.570667
      );

      const marker = new window.kakao.maps.Marker({
        position: markerPosition,
      });

      marker.setMap(this.map);
    },
  },
};
</script>

<style scoped>
.map-wrapper {
  width: 100%;
  height: 500px;
}
#map {
  width: 500px;
  height: 500px;
}

.result {
  height: 500px;
  border: 100px black;
  border-radius: 16px;
}
</style>
