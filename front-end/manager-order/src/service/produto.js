import { http } from './config'

export default {
    
    listar:() => {
        return http.get('produto/')
    },

    save:(form, idUsuario, idEstoque, idCategoria) =>{
        return http.post('produto/' + idCategoria + "/" + idEstoque + "/" + idUsuario, form)
    },

    update:(form, idUsuario, idEstoque, idCategoria, idProduto) => {
        return http.post('produto/update/' + idProduto + '/' + idCategoria + '/' + idEstoque + '/' + idUsuario, form)
    },

    delete:(id) => {
        return http.get('produto/delete/'+ id)
    },

    byId:(id) => {
        return http.get('produto/'+id)
    }
}