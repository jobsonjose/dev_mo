<template>
    <div class="container-grupo">
        <header-sub-nave></header-sub-nave>
        <header-nave></header-nave>
        <component-cadastro-grupo></component-cadastro-grupo>
        <component-listagem-grupo></component-listagem-grupo>
    </div>
</template>
<script>
import headerHome from '@/components/componentsTela/ComponenteHome/HeaderHome.vue';
import subHeaderHome from '@/components/componentsTela/ComponenteHome/SubHeaderHome.vue';
import cadastroGrupo from '@/components/componentsTela/componenteGrupo/Cadastro.vue';
import listagemGrupo from '@/components/componentsTela/componenteGrupo/Listagem.vue';

export default {
    name: "Grupo",
    data(){
        return {
            msg: 'Page do meetup Eduta'
        }
    },
    components:{
        'header-nave': headerHome,
        'header-sub-nave': subHeaderHome,
        'component-cadastro-grupo': cadastroGrupo,
        'component-listagem-grupo': listagemGrupo
    },
    data: () => ({
        nomeGrupo: null,
    }),
    method:{
        checkForm(){
            
        }
    }    
}
</script>
<style scoped>
.container-grupo{
    float: left;
    width: 100%;
    margin-top: 0.5%;
}
</style>