<template>
    <div class="container-acesso">
        <header-sub-nave></header-sub-nave>
        <header-nave></header-nave>
        <div-acesso></div-acesso>
        <div-cadastro></div-cadastro>
    </div>
</template>
<script>
import Acesso from '@/components/componentsTela/ComponenteUsuario/Acesso.vue';
import Cadastro from '@/components/componentsTela/ComponenteUsuario/Cadastro.vue';
import headerHome from '@/components/componentsTela/ComponenteHome/HeaderHome.vue';
import subHeaderHome from '@/components/componentsTela/ComponenteHome/SubHeaderHome.vue'

export default {
    name: "AcessoUsuario",
    components:{
        'div-acesso': Acesso,
        'div-cadastro': Cadastro,
        'header-nave': headerHome,
        'header-sub-nave': subHeaderHome
    },
    data(){
        return {
            msg: 'Page do meetup Eduta'
        }
    }    
}
</script>
<style scoped>
.container-acesso{
    float: left;
    width: 100%;
    margin-top: 0.5%;
}
</style>