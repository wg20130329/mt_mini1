import HttpRequest from '@/axios/api.request'

export const ParameterQryAction = () => {
  return HttpRequest.request({
    url: 'parameter/list',
    method: 'get'
  })
}

// export const UserAddAction = (parameter) => {
//   return HttpRequest.request({
//     url: 'user/',
//     method: 'post',
//     params: parameter
//   })
// }

export const ParameterUpdateAction = (parameter) => {
  return HttpRequest.request({
    url: 'parameter/create',
    method: 'post',
    params: parameter
  })
}

// export const UserDelAction = (parameter) => {
//   return HttpRequest.request({
//     url: 'user/',
//     method: 'delete',
//     params: {
//       no: parameter
//     }
//   })
// }

