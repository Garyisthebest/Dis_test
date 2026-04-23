<template>
  <div class="page">
    <h2>👤 用户管理</h2>

    <div class="form">
      <input v-model="name" placeholder="姓名" />
      <input v-model="age" placeholder="年龄" type="number" />
      <button @click="add">新增用户</button>
    </div>

    <div class="list">
      <div v-for="user in userList" :key="user.id" class="item">
        <span>{{ user.name }} · {{ user.age }}岁</span>
        <button @click="del(user.id)">删除</button>
      </div>
    </div>
  </div>
</template>

<script setup>
import { ref, onMounted } from 'vue'
import { getUserList, addUser, deleteUser } from '../api/user'

const name = ref('')
const age = ref('')
const userList = ref([])

onMounted(() => {
  fetchList()
})

async function fetchList() {
  const res = await getUserList()
  userList.value = res.data
}

async function add() {
  await addUser({ name: name.value, age: age.value })
  name.value = ''
  age.value = ''
  fetchList()
}

async function del(id) {
  await deleteUser(id)
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
input {
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
.item {
  padding: 12px;
  background: #f9f9f9;
  margin-bottom: 8px;
  display: flex;
  justify-content: space-between;
}
</style>