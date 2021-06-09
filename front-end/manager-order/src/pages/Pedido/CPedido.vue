<template>
    <div class="container-produto">
        <header-dashboard></header-dashboard>
        <c-pedido formStatus="CADT"></c-pedido>
    </div>
</template>
<script>
import cPedido from '@/components/componentsTela/ComponentePedido/Cadastro.vue'
import dashboardHeader from '@/components/componentsTela/ComponenteDashboard/HeaderDashboard.vue';

export default {
    name: "CPedido",
    components: {
        'header-dashboard':dashboardHeader,
        'c-pedido':cPedido
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