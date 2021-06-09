import { http } from './config'

export default {
    
    listar:() => {
        return http.get('pedido/')
    },

    save:(form, idUsuario) =>{
        return http.post('pedido/' + idUsuario, form)
    },

    filter:(form) =>{
        return http.post('pedido/filter/', form)
    },

    listarPedidoProduto:(idUsuario) => {
        return http.get('pedido/list/' + idUsuario);
    }
}