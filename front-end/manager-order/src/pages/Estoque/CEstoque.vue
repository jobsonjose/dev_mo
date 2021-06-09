<template>
    <div class="container-produto">
        <header-dashboard></header-dashboard>
        <ce-estoque formStatus="CADT"></ce-estoque>
    </div>
</template>
<script>
import ceEstoque from '@/components/componentsTela/ComponenteEstoque/Cadastro.vue'
import dashboardHeader from '@/components/componentsTela/ComponenteDashboard/HeaderDashboard.vue';

export default {
    name: "CEstoque",
    components: {
        'header-dashboard':dashboardHeader,
        'ce-estoque':ceEstoque
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