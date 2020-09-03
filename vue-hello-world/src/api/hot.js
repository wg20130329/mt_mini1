import HttpRequest from '@/axios/api.request'

export const HotQryAction = () => {
  return HttpRequest.request({
    url: 'hot/list',
    method: 'get'
  })
}


export const HotAddAction = (parameter) => {
  return HttpRequest.request({
    url: 'hot/create',
    method: 'post',
    params: parameter
  })
}

export const HotDelAction = (parameter) => {
  return HttpRequest.request({
    url: 'hot/del',
    method: 'post',
    params: {
      name: parameter
    }
  })
}

export const HotHistQryAction = () => {
  return HttpRequest.request({
    url: 'hot/histList',
    method: 'get'
  })
}

