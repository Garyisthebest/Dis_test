import axios from 'axios'

// 创建用户服务请求实例（8001）
const userRequest = axios.create({
  baseURL: 'http://localhost:8001',
  timeout: 5000
})

// 创建订单服务请求实例（8002）
const orderRequest = axios.create({
  baseURL: 'http://localhost:8002',
  timeout: 5000
})

export { userRequest, orderRequest }