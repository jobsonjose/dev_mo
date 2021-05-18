import { http } from './config'

export default {
    
    listar:() => {
        return http.get('categoria/')
    },

    save:(form) =>{
        return http.post('categoria/', form)
    },
}