<template>
  <div class="page">
    <h2>🛒 订单管理</h2>

    <div class="form">
      <input v-model="orderName" placeholder="订单名称" />

      <select v-model="userId">
        <option value="">请选择用户</option>
        <option v-for="user in userList" :key="user.id" :value="user.id">
          {{ user.name }} (ID:{{ user.id }})
        </option>
      </select>

      <button @click="create">创建订单</button>
    </div>

    <div class="list">
      <div v-for="order in orderList" :key="order.id" class="item">
        <div>
          <div>订单：{{ order.orderName }}</div>
          <div class="user">关联用户ID：{{ order.userId }}</div>
        </div>
        <button class="del-btn" @click="delOrder(order.id)">删除</button>
      </div>
    </div>
  </div>
</template>

<script setup>
import { ref, onMounted } from 'vue'
import { getOrderList, createOrder, deleteOrder } from '../api/order'
import axios from 'axios'

const orderName = ref('')
const userId = ref('')
const orderList = ref([])
const userList = ref([])

onMounted(() => {
  fetchList()
  fetchUserList()
})

// 获取订单列表
async function fetchList() {
  const res = await getOrderList()
  orderList.value = res.data
}

// 获取用户列表
async function fetchUserList() {
  const res = await axios.get('http://localhost:8001/user')
  userList.value = res.data
}

// 创建订单
async function create() {
  await createOrder({
    orderName: orderName.value,
    userId: userId.value
  })
  orderName.value = ''
  userId.value = ''
  fetchList()
}

// 删除订单
async function delOrder(id) {
  if (!confirm('确定删除该订单？')) return
  await deleteOrder(id)
  fetchList()
}
</script>

<style scoped>
.page {
  padding: 20px;
}
.form {
  display: flex;
  gap: 10px;
  margin: 20px 0;
}
input, select {
  padding: 8px 12px;
  flex: 1;
}
button {
  padding: 8px 16px;
  background: #42b983;
  color: #fff;
  border: none;
  cursor: pointer;
}
.del-btn {
  background: #ff4d4f;
}
.item {
  padding: 12px;
  background: #f9f9f9;
  margin-bottom: 8px;
  display: flex;
  justify-content: space-between;
  align-items: center;
}
.user {
  color: #16a34a;
  font-size: 14px;
  margin-top: 6px;
}
</style>