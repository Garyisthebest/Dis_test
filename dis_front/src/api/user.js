import { userRequest } from '../utils/request'

// 获取用户列表
export function getUserList() {
  return userRequest.get('/user')
}

// 新增用户
export function addUser(data) {
  return userRequest.post('/user', data)
}

// 删除用户
export function deleteUser(id) {
  return userRequest.delete(`/user/${id}`)
}