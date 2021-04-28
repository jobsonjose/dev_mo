import Vue from 'vue'
import Router from 'vue-router'
import Home from '@/pages/Home'
import Acesso from '@/pages/AcessoUsuario'
import Assinatura from '@/pages/Assinatura'
import Grupo from '@/pages/Grupo'
import Beneficio from '@/pages/Beneficio'
import Dashboard from '@/pages/Dashboard'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'Home',
      component: Home
    },
    {
      path: '/acesso',
      name: 'Acesso',
      component: Acesso
    },
    {
      path: '/assinatura',
      name: 'Assinatura',
      component: Assinatura
    },
    {
      path: '/grupo',
      name: 'Grupo',
      component: Grupo
    },
    {
      path: '/beneficio',
      name: 'Beneficio',
      component: Beneficio
    },
    {
      path: '/dashboard',
      name: 'Dashboard',
      component: Dashboard
    }
  ]
})
