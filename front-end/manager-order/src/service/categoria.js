import { http } from './config'

export default {
    
    listar:() => {
        return http.get('categoria/')
    },

    save:(form) =>{
        return http.post('categoria/', form)
    },

    update:(form, id) => {
        return http.post('categoria/update/'+id, form)
    },

    delete:(id) => {
        return http.get('categoria/delete/'+id)
    },

    findById:(id) => {
        return http.get('categoria/'+id)
    }
}