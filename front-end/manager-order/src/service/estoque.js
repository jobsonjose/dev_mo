import { http } from './config'

export default {
    
    listar:() => {
        return http.get('estoque/')
    },

    listarUsuario:(idUsuario) => {
        return http.get('estoque/listgroup/' + idUsuario)
    },

    save:(form, idUsuario) => {
        return http.post('estoque/save/' + idUsuario, form)
    },

    listarEstoqueProduto:(idEstoque) => {
        return http.get('estoque/estoqueproduto/' + idEstoque);
    },

    delete:(idEstoque) => {
        return http.get('estoque/delete/' + idEstoque)
    }
}