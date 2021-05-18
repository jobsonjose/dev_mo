<template>
    <div class="container-produto">
        <header-dashboard></header-dashboard>
        <ce-produto formStatus="CADT" v-bind:idUsuarioProps="this.idUsuario"></ce-produto>
    </div>
</template>
<script>
import ceProduto from '@/components/componentsTela/ComponenteProduto/Cadastro.vue'
import dashboardHeader from '@/components/componentsTela/ComponenteDashboard/HeaderDashboard.vue';

export default {
    name: "CProduto",
    components: {
        'header-dashboard':dashboardHeader,
        'ce-produto':ceProduto
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