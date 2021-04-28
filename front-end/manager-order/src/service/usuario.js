import { http } from './config'

export default {
    
    listar:() => {
        return http.get('usuario/')
    },

    save:(form, idGrupo) =>{
        return http.post('usuario/' + idGrupo, form)
    },

    login:(email, senha) => {
        return http.get('usuario/'+email+'/'+senha);
    }
}