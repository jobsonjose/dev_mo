<template>
    <div class="container-produto">
        <header-dashboard></header-dashboard>
        <ce-produto formStatus="EDITA" v-bind:idProdutoProps="this.idProduto"></ce-produto>
    </div>
</template>
<script>
import ceProduto from '@/components/componentsTela/ComponenteProduto/Cadastro.vue'
import dashboardHeader from '@/components/componentsTela/ComponenteDashboard/HeaderDashboard.vue';

export default {
    name: "EProduto",
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
        idProduto: 0
    }),
    mounted(){
        if(this.$route.params.idProduto > 0){
            this.idProduto = parseInt(this.$route.params.idProduto);
        }
    }
}
</script>
<style >
    
</style>