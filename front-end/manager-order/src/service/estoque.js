import { http } from './config'

export default {
    
    listar:() => {
        return http.get('estoque/')
    },

    listarUsuario:(idUsuario) => {
        return http.get('estoque/' + idUsuario)
    },

    save:(form) =>{
        return http.post('estoque/', form)
    },
}