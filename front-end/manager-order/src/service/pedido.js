import { http } from './config'

export default {
    
    listar:() => {
        return http.get('pedido/')
    },

    save:(form) =>{
        return http.post('pedido/', form)
    },

    filter:(form) =>{
        return http.post('pedido/filter/', form)
    }
}