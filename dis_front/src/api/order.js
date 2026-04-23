import { orderRequest } from '../utils/request'

// 获取订单列表
export function getOrderList() {
  return orderRequest.get('/order/list')
}

// 创建订单
export function createOrder(data) {
  return orderRequest.post('/order', data)
}
// 删除订单
export function deleteOrder(id) {
  return orderRequest.delete(`/order/${id}`)
}