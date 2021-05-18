<template>
    <div class="container-produto">
        <header-dashboard v-bind:idUsuario="this.IdUsuario"></header-dashboard>
        <div class="row-produto">
            <img class="create-produto" src="@/assets/add-file.png">
            <div class="title-cadastro" v-on:click="cadastro()">Cadastrar Produto</div>
        </div>
        <div class="container-list-produtos">
            <table style="width: 100%; margin: 0%;" id="table-grupos">
                <thead>
                    <tr class="row-heard-table">
                    <th>Nome</th>
                    <th>Valor</th>
                    <th>Descrição</th>
                    <th>Usuario</th>
                    <th>Funções</th>
                    </tr>
                </thead>
                <tbody>
                    <tr class="row-heard-table" v-bind:key="produto.id" v-for="produto in produtos">
                        <td>{{produto.nome}}</td>
                        <td>{{produto.valor}}</td>
                        <td>{{produto.descricao}}</td>
                        <td>{{produto.idUsuario}}</td>
                        <td><button v-on:click="edit(produto.id)">Editar</button><button v-on:click="del(produto.id)">Deletar</button></td>
                    </tr>
                </tbody>
            </table>
        </div>
    </div>
</template>
<script>
import serviceGlobal from '@/service/serviceGlobal';
import serviceProduto from '@/service/produto';
import dashboardHeader from '@/components/componentsTela/ComponenteDashboard/HeaderDashboard.vue';

export default {
    name: "Produto",
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
        produtos: [
            {
                id: 0,
                nome: "",
                valor: 0.0,
                descricao: "",
                idUsuario: ""
            }
        ],
        IdUsuario: 0
    }),
    mounted() {
        serviceProduto.listar().then(resposta => {
            this.produtos = resposta.data;
            console.log(this.produtos);
        });
        if(this.$route.params.idUsuario > 0){
            this.IdUsuario = parseInt(this.$route.params.idUsuario);
            console.log(this.IdUsuario);
        }
    },
    methods:{
        edit(id){
            this.$router.push("/dashboard/produto/eproduto/"+id);
        },
        del(id){
            serviceProduto.delete(id).then(resposta => {
                console.log(resposta.data);
            });

            this.$router.push("/dashboard/produto/"+this.IdUsuario);
        },
        cadastro(){
            this.$router.push("/dashboard/produto/cproduto/"+this.IdUsuario);
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
    .container-list-produtos{
        float: left;
        width: 95%;
        margin: 0.4% 2.0%;
        border: 2px solid black;
        border-radius: 30px;
    }
    .row-produto{
        float: left;
        width: 100%;
        transition: 1.2s;
        border: 1px solid white;
    }
    .row-produto:hover{
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
    .create-produto{
        text-align: center;
        background: white;
        padding: 0.3%;
        margin: 0.4%;
        float: left;
        color: black;
        transition: 1.2s;
        border: 1px solid white;
    }

    .create-produto:hover{
        cursor: cell;
    }
</style>