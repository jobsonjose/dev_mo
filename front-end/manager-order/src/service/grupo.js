import { http } from './config'

export default {
    
    listar:() => {
        return http.get('grupo/')
    },

    save:(form) =>{
        return http.post('grupo/', form)
    },
}