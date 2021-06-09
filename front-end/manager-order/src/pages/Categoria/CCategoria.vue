<template>
    <div class="container-produto">
        <header-dashboard></header-dashboard>
        <ce-categoria formStatus="CADT"></ce-categoria>
    </div>
</template>
<script>
import ceCategoria from '@/components/componentsTela/ComponenteCategoria/Cadastro.vue'
import dashboardHeader from '@/components/componentsTela/ComponenteDashboard/HeaderDashboard.vue';

export default {
    name: "CCategoria",
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
        idUsuario: Number
    }),
    mounted(){
        if(this.$route.params.idUsuario > 0){
            this.idUsuario = this.$route.params.idUsuario;
        }
    }
}
</script>
<style >
    
</style>