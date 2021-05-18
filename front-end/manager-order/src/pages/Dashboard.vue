<template>
    <div class="container-dashboard">
        <header-dashboard v-bind:idUsuario="this.idUsuario"></header-dashboard>
        <div class="container-graphic">
            <div class="block-chart">
                <line-chart :chart-data="chartData"></line-chart>
            </div>
            <div class="block-filter">
                <div class="block-form">
                    <div class="row-title">
                        <p class="title-filter">Filtragem dos Gráficos</p>
                    </div>
                    <div id="app">
                        <div class="name-form">
                            <label>Data Inicial</label>
                        </div>
                        <div class="row-form">
                            <input type="date" id="dataStart" v-model="dataStart" name="dataStart" placeholder="Data Inicial">
                        </div>
                        <div class="name-form">
                            <label>Data Final</label>
                        </div>
                        <div class="row-form">
                            <input type="date" id="dataEnd" v-model="dataEnd" name="dataEnd" placeholder="Data Final">
                        </div>
                        <div class="submit-form">
                            <button v-on:click="filter()" class="btn-form-filter">Filtrar</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>
<script>
import servicePedido from '@/service/pedido';
import dashboardHeader from '@/components/componentsTela/ComponenteDashboard/HeaderDashboard.vue';
import LineChart from '@/components/charts/LineChart';

export default {
    name: "Dashboard",
    data(){
        return {
            msg: 'Page do meetup Eduta',
            chartData: {
                labels: [4, 5],
                datasets: [
                    {
                        label: 'Data One',
                        data: [3, 2]
                    },
                    {
                        label: 'Data One',
                        data: [1, 5]
                    }
                ]
            },
            dataStart: '2021-05-02',
            dataEnd: '2021-04-30',
            idUsuario: 0
        }
    },
    components: {
        'header-dashboard': dashboardHeader,
        'line-chart': LineChart
    },
    methods:{
        filter(){
            servicePedido.filter().then( resposta => {
                console.log(resposta.data);
            });
        }
    },
    mounted() {
        if(this.$route.params.idUsuario > 0){
            this.idUsuario = parseInt(this.$route.params.idUsuario);
        }
    }
    
}
</script>
<style scoped>
    .container-graphic{
        width: 100%;
        padding: 5% 8%;
        float: left;       
    }
    .block-chart{
        width: 30%;
        max-height: 400px;
        float: left;
    }
    .block-filter{
        width: 30%;
        float: left;
        background: #4c1c26;
        margin-left: 20%;
    }
    .row-title{
        background: white;
        border-radius: 30px;
        margin: 2% 10%;
    }
    .title-filter{
        color: #4c1c26;
        text-align: center;
        font-size: 18px;
        padding: 2%
    }
    .name-form label{
        color: white;
    }
    .name-form{
        text-align: left;
        padding: 2% 10%;
    }
    .row-form{
        width: 77%;
        margin: 2% 8% 2%;
    }
    .row-form input, .row-form textarea{
        width: 100%;
        padding: 2% 4%;
        border-radius: 30px;
        border: 2px solid rgba(249, 239, 193, 0.77);
        opacity: 1;
        box-shadow: 0 0 0 0;
        outline: 0;
    }
    .row-form input:hover, .row-form textarea:hover{
        border: 2px solid rgba(230, 189, 0, 0.77);
    }
    .btn-form-filter{
        width: 30%;
        background: rgba(230, 189, 0, 0.77);
        border: 1px solid #d82e52;
        opacity: 0.7;
        color: white;
        padding: 1%;
        transition: 0.6s;
        margin: 10% 2%
    }
    .btn-form-filter:hover{
        background: white;
        color: black;
        border: 1px solid rgba(230, 189, 0, 0.77);
    }
</style>