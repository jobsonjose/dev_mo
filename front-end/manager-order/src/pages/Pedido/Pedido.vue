<template>
    <div class="container-pedido">
        <header-dashboard v-bind:idUsuario="this.IdUsuario"></header-dashboard>
        <div class="row-pedido">
            <img class="create-pedido" src="@/assets/add-file.png">
            <div class="title-cadastro" v-on:click="cadastro()">Cadastrar Pedido</div>
        </div>
        <div class="container-list-pedido">
            <b-table :items="items" :fields="fields" striped responsive="sm">
                <template #cell(show_details)="row">
                    <b-button size="sm" @click="row.toggleDetails" class="mr-2">
                        {{ row.detailsShowing ? 'Hide' : 'Show'}} Visualizar
                    </b-button>
                </template>
                <template #row-details="row">
                    <b-card>
                        <b-table :items="row.item.listproduto" :fields="fieldsSeconds" striped responsive="sm"></b-table>
                        <b-button size="sm" @click="row.toggleDetails">Fechar</b-button>
                    </b-card>
                </template>
            </b-table>
        </div>
    </div>
</template>
<script>
import serviceGlobal from '@/service/serviceGlobal';
import servicePedido from '@/service/pedido';
import dashboardHeader from '@/components/componentsTela/ComponenteDashboard/HeaderDashboard.vue';

export default {
    name: "Pedido",
    components: {
        'header-dashboard':dashboardHeader
    },
    data(){
        return {
            msg: 'Page do meetup Eduta'
        }
    },
    mixins: [serviceGlobal],
    data: () => ({
        items: [
            {
                titulo: "",
                descricao: "",
                tipoPedido: "",
                dataInicial: "",
                listproduto: [
                    { nome: "", quantidade: 0, valor: 0.0},
                    { nome: "", quantidade: 0, valor: 0.0}
                ]
            }
        ],
        fieldsSeconds: ['nome', 'quantidade', 'valor'],
        fields: ['titulo', 'tipoPedido', 'dataInicial', 'show_details'],
        IdUsuario: 0
    }),
    mounted() {
        if(this.$route.params.idUsuario > 0){
            this.IdUsuario = parseInt(this.$route.params.idUsuario);
            console.log(this.IdUsuario);
        }

        servicePedido.listarPedidoProduto(this.IdUsuario).then(resposta => {
            this.items = resposta.data;
            console.log(this.items);
        });
    },
    methods:{
        cadastro(){
            this.$router.push("/dashboard/pedido/cpedido/"+this.IdUsuario);
        },
        visualizarestoque(){
            console.log(this.items);
        }
    }
}
</script>
<style scoped>
    table {
        border-collapse: collapse;
        width: 100%;
    }
    th, td {
        text-align: left;
        padding: 15px;
    }
    tr:nth-child(even){background-color: #f2f2f2}
    .container-list-pedido{
        float: left;
        width: 95%;
        margin: 0.4% 2.0%;
        border: 2px solid black;
        border-radius: 30px;
    }
    .row-pedido{
        float: left;
        width: 100%;
        transition: 1.2s;
        border: 1px solid white;
    }
    .row-pedido:hover{
        background: #eceaea;
    }
    .title-cadastro{
        float: left;
        text-align: left;
        font-weight: 600;
        font-size: 15px;
        color: black;
        padding: 2.5% 0.8%
    }
    .create-pedido{
        text-align: center;
        background: white;
        padding: 0.3%;
        margin: 0.4%;
        float: left;
        color: black;
        transition: 1.2s;
        border: 1px solid white;
    }

    .create-pedido:hover{
        cursor: cell;
    }
</style>