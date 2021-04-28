<template>
    <div class="container-apresentacao">
        <header-sub-nave></header-sub-nave>
        <header-nave></header-nave>
        <div class="container-beneficio">
            <info-benef titulo="Objetivo" description="O objetivo é trabalhar com um controle mais fixo em produtos e suas entradas e saidas.
            Dessa forma, vai ser possivel encontrar suas vantagens nos estoques e suas falhas, facilitando assim o crescimento da empresa."></info-benef>
            <info-benef titulo="As assinaturas" description="As assinaturas vêm para permitir ao usuário uma melhor forma e suporta para trabalhar, 
            ampliando assim a possibilidade do usuário ter mais estoques."></info-benef>
            <info-benef titulo="Desenvolvimento" description="O desenvolvimento de nosso sistema está empregado na melhor qualidade do trabalho e criar mais 
            necessidade que vão ser apresentadas pelos clientes Ultra e Premium"></info-benef>
        </div>
    </div>
</template>
<script>
import headerHome from '@/components/componentsTela/ComponenteHome/HeaderHome.vue';
import subHeaderHome from '@/components/componentsTela/ComponenteHome/SubHeaderHome.vue';
import infoBenef from '@/components/componentsTela/ComponenteBeneficio/infoBenef.vue';

export default {
    name: "Beneficio",
    data(){
        return {
            msg: 'Page do meetup Eduta'
        }
    },
    components:{
        'header-nave': headerHome,
        'header-sub-nave': subHeaderHome,
        'info-benef': infoBenef
    }    
}
</script>
<style scoped>
.container-apresentacao{
    float: left;
    width: 100%;
    margin-top: 0.5%;
}

.container-beneficio{
    margin: 11% 1% 5%;
}
</style>