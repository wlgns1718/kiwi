import Vue from "vue";
import VueRouter from "vue-router";
import { onlyAuthUser } from "@/api/logincheck";

//views
import AppMain from "@/views/AppMain.vue";
import AppTour from "@/views/AppTour.vue";
Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    name: "main",
    component: AppMain,
  },
  {
    path: "/tour",
    name: "tour",
    component: AppTour,
  },
  {
    path: "/user",
    name: "user",
    component: () => import("@/views/AppUser"),
    redirect: "/user/login",
    children: [
      {
        path: "login",
        name: "UserLogin",
        component: () => import("@/components/user/TheLogin"),
      },
      {
        path: "regist",
        name: "UserRegist",
        component: () => import("@/components/user/TheRegist"),
      },
      {
        path: "mypage",
        name: "UserMypage",
        component: () => import("@/components/user/TheMypage"),
      },
    ],
  },
  {
    path: "/board",
    name: "board",
    component: () => import("@/views/AppBoard"),
    redirect: "/board/list",
    children: [
      {
        path: "list",
        name: "bardlist",
        component: () => import("@/components/board/BoardList"),
      },
      {
        path: "detail/:no",
        name: "boarddetail",
        beforeEnter: onlyAuthUser,
        component: () => import("@/components/board/BoardDetail"),
      },
      {
        path: "modify/:no",
        name: "boardmodify",
        beforeEnter: onlyAuthUser,
        component: () => import("@/components/board/BoardModify"),
      },
      {
        path: "write",
        name: "boardwrite",
        beforeEnter: onlyAuthUser,
        component: () => import("@/components/board/BoardWrite"),
      },
    ],
  },
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes,
});

export default router;
