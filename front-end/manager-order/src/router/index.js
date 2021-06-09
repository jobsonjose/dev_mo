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
import Categoria from '@/pages/Categoria/Categoria'
import CCategoria from '@/pages/Categoria/CCategoria'
import ECategoria from '@/pages/Categoria/ECategoria'
import Estoque from '@/pages/Estoque/Estoque';
import CEstoque from '@/pages/Estoque/CEstoque';
import Pedido from '@/pages/Pedido/Pedido';
import CPedido from '@/pages/Pedido/CPedido';

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
    },
    {
      path: '/dashboard/categoria/:idUsuario',
      name: 'Categoria',
      component: Categoria
    },
    {
      path: '/dashboard/categoria/ccategoria/:idUsuario',
      name: 'CCategoria',
      component: CCategoria
    },
    {
      path: '/dashboard/categoria/ecategoria/:idCategoria',
      name: 'ECategoria',
      component: ECategoria
    },
    {
      path: '/dashboard/estoque/:idUsuario',
      name: 'Estoque',
      component: Estoque
    },
    {
      path: '/dashboard/estoque/cestoque/:idUsuario',
      name: 'CEstoque',
      component: CEstoque
    },
    {
      path: '/dashboard/pedido/:idUsuario',
      name: 'Pedido',
      component: Pedido
    },
    {
      path: '/dashboard/pedido/cpedido/:idUsuario',
      name: 'CPedido',
      component: CPedido
    }
  ]
})
