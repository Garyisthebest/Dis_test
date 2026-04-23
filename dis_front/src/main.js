import { createApp } from 'vue'
import App from './App.vue'
import router from './router' // 这里必须能找到

const app = createApp(App)
app.use(router)
app.mount('#app')