import Vue from 'vue'
import Router from 'vue-router'
import Home from '@/pages/Home'
import Acesso from '@/pages/AcessoUsuario'
import Assinatura from '@/pages/Assinatura'
import Grupo from '@/pages/Grupo'
import Beneficio from '@/pages/Beneficio'
import Dashboard from '@/pages/Dashboard'
import Produto from '@/pages/Produto/Produto'
import CProduto from '@/pages/Produto/CProduto'
import EProduto from '@/pages/Produto/EProduto'

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
      path: '/dashboard/:idUsuario',
      name: 'Dashboard',
      component: Dashboard
    },
    {
      path: '/dashboard/produto/:idUsuario',
      name: 'Produto',
      component: Produto
    },
    {
      path: '/dashboard/produto/eproduto/:idProduto',
      name: 'EProduto',
      component: EProduto
    },
    {
      path: '/dashboard/produto/cproduto/:idUsuario',
      name: 'CProduto',
      component: CProduto
    }
  ]
})
