<template>
  <div class="nav-box">
    <router-link to="/user">用户管理</router-link>
    <router-link to="/order">订单管理</router-link>
  </div>

  <router-view />
</template>

<style scoped>
.nav-box {
  padding: 20px;
  background: #f0f4f8;
  gap: 30px;
  display: flex;
  font-size: 18px;
}

.router-link-active {
  color: #16a34a;
  font-weight: bold;
}
</style>