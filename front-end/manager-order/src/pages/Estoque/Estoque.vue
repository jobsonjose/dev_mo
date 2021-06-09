<template>
    <div class="container-estoque">
        <header-dashboard v-bind:idUsuario="this.IdUsuario"></header-dashboard>
        <div class="row-estoque">
            <img class="create-estoque" src="@/assets/add-file.png">
            <div class="title-cadastro" v-on:click="cadastro()">Cadastrar Estoque</div>
        </div>
        <div class="container-list-estoque">
            <b-table :items="items" :fields="fields" striped responsive="sm">
                <template #cell(show_details)="row">
                    <b-button size="sm" @click="row.toggleDetails" class="mr-2">
                        {{ row.detailsShowing ? 'Hide' : 'Show'}} Visualizar
                    </b-button>
                </template>
                <template #row-details="row">
                    <b-card>
                        <b-table :items="row.item.listEstoqueProduto" :fields="fieldsSeconds" striped responsive="sm"></b-table>
                        <b-button size="sm" @click="row.toggleDetails">Fechar</b-button>
                    </b-card>
                </template>
            </b-table>
        </div>
    </div>
</template>
<script>
import serviceGlobal from '@/service/serviceGlobal';
import serviceEstoque from '@/service/estoque';
import dashboardHeader from '@/components/componentsTela/ComponenteDashboard/HeaderDashboard.vue';

export default {
    name: "Estoque",
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
                idEstoque: 0,
                nome: "",
                total_produtos: 0,
                grupo: 0,
                listEstoqueProduto: [
                    { nome: "", quantidade: 0, dataCriacao: ""},
                    { nome: "", quantidade: 0, dataCriacao: ""}
                ]
            }
        ],
        fieldsSeconds: ['nome', 'quantidade', 'dataCriacao'],
        fields: ['nome', 'total_produtos', 'grupo', 'show_details'],
        IdUsuario: 0
    }),
    mounted() {
        if(this.$route.params.idUsuario > 0){
            this.IdUsuario = parseInt(this.$route.params.idUsuario);
            console.log(this.IdUsuario);
        }

        serviceEstoque.listarEstoqueProduto(this.IdUsuario).then(resposta => {
            this.items = resposta.data;
            console.log(this.items);
        });
    },
    methods:{
        del(id){
            serviceEstoque.delete(id).then(resposta => {
                console.log(resposta.data);
            });

            this.$router.push("/dashboard/estoque/"+this.IdUsuario);
        },
        cadastro(){
            this.$router.push("/dashboard/estoque/cestoque/"+this.IdUsuario);
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
    .container-list-estoque{
        float: left;
        width: 95%;
        margin: 0.4% 2.0%;
        border: 2px solid black;
        border-radius: 30px;
    }
    .row-estoque{
        float: left;
        width: 100%;
        transition: 1.2s;
        border: 1px solid white;
    }
    .row-estoque:hover{
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
    .create-estoque{
        text-align: center;
        background: white;
        padding: 0.3%;
        margin: 0.4%;
        float: left;
        color: black;
        transition: 1.2s;
        border: 1px solid white;
    }

    .create-estoque:hover{
        cursor: cell;
    }
</style>