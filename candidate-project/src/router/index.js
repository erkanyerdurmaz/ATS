import Vue from 'vue'
import Router from 'vue-router'
import CandidateCrud from '@/components/CandidateCrud'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'CandidateCrud',
      component: CandidateCrud
    }
  ]
})
