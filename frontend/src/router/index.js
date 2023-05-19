import Vue from "vue";
import VueRouter from "vue-router";

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
        component: () => import("@/components/user/TheLogin")
      },
      {
        path: "regist",
        name: "UserRegist",
        component: () => import("@/components/user/TheRegist"),
      }
    ]
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
        component: () => import("@/components/board/BoardDetail"),
      },
      {
        path: "modify/:no",
        name: "boardmodify",
        component: () => import("@/components/board/BoardModify"),
      },
      {
        path: "write",
        name: "boardwrite",
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
