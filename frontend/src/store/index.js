import Vue from "vue";
import Vuex from "vuex";
import http from "@/api/http";
import createPersistedState from "vuex-persistedstate";
Vue.use(Vuex);

export default new Vuex.Store({
  plugins: [
    createPersistedState({
      storage: sessionStorage,
    })
  ],
  state: {
    sidos: [{ value: "", text: "선택하세요" }],
    guguns: [{ value: "", text: "선택하세요" }],
    tourtype: "",
    tours: [],
    tour: null,
    //user에 대한 state 정보
    userinfo: {
      userid: "",
      username: "",
    }
  },
  getters: {},
  mutations: {
    //지도에 대한 mutations--------------------------------------------------------------
    SET_SIDO_LIST(state, sidos) {
      sidos.forEach((sido) => {
        state.sidos.push({ value: sido.code, text: sido.name });
      });
    },
    SET_GUGUN_LIST(state, guguns) {
      guguns.forEach((gugun) => {
        state.guguns.push({ value: gugun.code, text: gugun.name });
      });
    },
    SET_TOUR_TYPE(state, tourtype) {
      state.tourtype = tourtype;
    },
    CLEAR_SIDO_LIST(state) {
      state.sidos = [{ value: "", text: "선택하세요" }];
    },
    CLEAR_GUGUN_LIST(state) {
      state.guguns = [{ value: "", text: "선택하세요" }];
    },
    CLEAR_TOUR_LIST(state) {
      state.tours = [];
      state.tour = null;
    },
    SET_TOUR_LIST(state, tours) {
      state.tours = tours;
    },
    SET_DETAIL_TOUR(state, tour) {
      state.tour = tour;
    },
    // 유저에 대한 mutations--------------------------------------------
    SET_USER_INFO(state, userInfo) {
      state.userinfo.userid = userInfo.userid;
      state.userinfo.username = userInfo.username;
    },
    //보드에 대한 mutations--------------------------------------------------



  },
  actions: {
    getSido({ commit }) {
      http
        .get(`/tour/sidoList`)
        .then(({ data }) => {
          commit("SET_SIDO_LIST", data);
        })
        .catch((error) => {
          console.log(error);
        });
    },
    getGugun({ commit }, sidoCode) {
      http
        .get(`/tour/sigunList/${sidoCode}`)
        .then(({ data }) => {
          // console.log(commit, response);
          commit("SET_GUGUN_LIST", data);
        })
        .catch((error) => {
          console.log(error);
        });
    },
    getTourList({ commit }, params) {
      http
        .get(`/tour/tourList/${params[0]}/${params[1]}/${params[2]}`)
        .then(({ data }) => {
          data.forEach((d) => {
            d["expanded"] = false;
          });
          console.log(data);
          commit("SET_TOUR_LIST", data);
        })
        .catch((error) => {
          console.log(error);
        });
    },
    getUser({ commit }, userInfo) {
      http.post(`/vue/user/login`, JSON.stringify(userInfo)).then(({ data }) => {
        console.log(data);
        commit("SET_USER_INFO", data);
      })
        .catch((error) => {
          console.log(error);
        });
    },
  },
  modules: {},
});
