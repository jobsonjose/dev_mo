<template>
    <div class="container-dashboard">
        <header-dashboard></header-dashboard>
    </div>
</template>
<script>
import serviceGlobal from '@/service/serviceGlobal';
import dashboardHeader from '@/components/componentsTela/ComponenteDashboard/HeaderDashboard.vue';

export default {
    name: "Dashboard",
    data(){
        return {
            msg: 'Page do meetup Eduta'
        }
    },
    mixins: [serviceGlobal],
    components: {
        'header-dashboard': dashboardHeader
    }
    
}
</script>
<style scoped>

</style>