<template>
  <div class="map-wrapper">
    <div id="map"></div>
  </div>
</template>

<script>
import { mapState } from "vuex";

export default {
  name: "TourMap",
  components: {},
  data() {
    return {
      map: null,
      markers: [],
      selectedInfoWindow: null,
    };
  },
  computed: {
    ...mapState("tourStore", ["tours"]),
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
  watch: {
    tours() {
      this.markers = [];
      this.selectedInfoWindow = null;
      this.displayMarker();
    },
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
        center: new window.kakao.maps.LatLng(36.4913023798608, 127.84327064814485),
        level: 13,
      };

      this.map = new window.kakao.maps.Map(container, options);
      // this.loadMaker();
    },
    // 지정한 위치에 마커 불러오기
    loadMaker() {
      const markerPosition = new window.kakao.maps.LatLng(36.4913023798608, 127.84327064814485);

      const marker = new window.kakao.maps.Marker({
        position: markerPosition,
      });

      marker.setMap(this.map);
    },
    displayMarker() {
      // console.log(this.tours);
      const imageSrc = "https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/markerStar.png"; // 마커 이미지
      for (var i = 0; i < this.tours.length; i++) {
        // 좌표 넣어둔 배열만큼
        // 마커 이미지의 이미지 크기 입니다
        const imageSize = new window.kakao.maps.Size(24, 35);
        // 마커 이미지를 생성합니다
        const markerImage = new window.kakao.maps.MarkerImage(imageSrc, imageSize);
        // 마커를 생성합니다
        const markerPosition = new window.kakao.maps.LatLng(
          this.tours[i].latitude,
          this.tours[i].longitude
        );

        const marker = new window.kakao.maps.Marker({
          // map: map, // 마커를 표시할 지도
          position: markerPosition, // 마커를 표시할 위치
          title: this.tours[i].title, // 마커의 타이틀, 마커에 마우스를 올리면 타이틀이 표시됩니다
          image: markerImage, // 마커 이미지
        });
        marker.setMap(this.map);

        // 생성된 마커를 배열에 추가합니다
        this.markers.push(marker);

        // infowindow
        const infowindow = new window.kakao.maps.InfoWindow({
          content: this.tours[i].title,
          position: this.tours[i].latitude,
        });

        // 마커 이벤트 추가 (누르면 정보 오버레이 표시)
        this.map.addListener(marker, "click", this.makeClickListener(marker, infowindow));
      }

      // 첫번째 검색 정보를 이용하여 지도 중심을 이동 시킵니다
      const markerFirstPosition = new window.kakao.maps.LatLng(
        this.tours[0].latitude,
        this.tours[0].longitude
      );
      this.map.setCenter(markerFirstPosition);
      this.map.setLevel(6);
    },
    moveCenter(lat, lng) {
      this.map.setCenter(new window.kakao.maps.LatLng(lat, lng));
    },
    makeClickListener(marker, infowindow) {
      return function () {
        !!this.selectedInfoWindow && this.selectedInfoWindow.close();
        infowindow.open(this.map, marker);
        // selectedMarker = selected;
        this.selectedInfoWindow = infowindow;
      };
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
  display: inline-block;
}
</style>
