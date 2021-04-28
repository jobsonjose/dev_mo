<template>
    <div class="container-produto">
        <header-sub-nave></header-sub-nave>
        <header-nave></header-nave>
    </div>
</template>
<script>
import serviceGlobal from '@/service/serviceGlobal';
import headerHome from '@/components/componentsTela/ComponenteHome/HeaderHome.vue';
import subHeaderHome from '@/components/componentsTela/ComponenteHome/SubHeaderHome.vue';

export default {
    name: "Produto",
    components: {
        'header-nave': headerHome,
        'header-sub-nave': subHeaderHome
    },
    data(){
        return {
            msg: 'Page do meetup Eduta'
        }
    },
    
}
</script>
<style scoped>

</style>