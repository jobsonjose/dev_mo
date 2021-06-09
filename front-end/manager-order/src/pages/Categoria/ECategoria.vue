<template>
    <div class="container-produto">
        <header-dashboard></header-dashboard>
        <ce-categoria formStatus="EDITA"></ce-categoria>
    </div>
</template>
<script>
import ceCategoria from '@/components/componentsTela/ComponenteCategoria/Cadastro.vue'
import dashboardHeader from '@/components/componentsTela/ComponenteDashboard/HeaderDashboard.vue';

export default {
    name: "ECategoria",
    components: {
        'header-dashboard':dashboardHeader,
        'ce-categoria':ceCategoria
    },
    data(){
        return {
            msg: 'Page do manager order'
        }
    },
    data: () => ({
        idCategoria: 0
    }),
    mounted(){
        if(this.$route.params.idCategoria > 0){
            this.idCategoria = parseInt(this.$route.params.idCategoria);
        }
    }
}
</script>
<style >
    
</style>