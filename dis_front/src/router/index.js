import { createRouter, createWebHistory } from 'vue-router'

// 引入页面
import UserView from '../views/UserView.vue'
import OrderView from '../views/OrderView.vue'

// 路由规则
const routes = [
  {
    path: '/',
    redirect: '/user' // 默认页
  },
  {
    path: '/user',
    component: UserView
  },
  {
    path: '/order',
    component: OrderView
  }
]

// 创建路由
const router = createRouter({
  history: createWebHistory(),
  routes
})

export default router