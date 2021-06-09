<template>
    <div class="container-categoria">
        <header-dashboard v-bind:idUsuario="this.IdUsuario"></header-dashboard>
        <div class="row-categoria">
            <img class="create-categoria" src="@/assets/add-file.png">
            <div class="title-cadastro" v-on:click="cadastro()">Cadastrar Categoria</div>
        </div>
        <div class="container-list-categoria">
            <table style="width: 100%; margin: 0%;" id="table-grupos">
                <thead>
                    <tr class="row-heard-table">
                    <th>Nome</th>
                    <th>Descrição</th>
                    </tr>
                </thead>
                <tbody>
                    <tr class="row-heard-table" v-bind:key="categoria.id" v-for="categoria in categorias">
                        <td>{{categoria.nome}}</td>
                        <td>{{categoria.descricao}}</td>
                        <td><button v-on:click="edit(categoria.id)">Editar</button><button v-on:click="del(categoria.id)">Deletar</button></td>
                    </tr>
                </tbody>
            </table>
        </div>
    </div>
</template>
<script>
import serviceGlobal from '@/service/serviceGlobal';
import serviceCategoria from '@/service/categoria';
import dashboardHeader from '@/components/componentsTela/ComponenteDashboard/HeaderDashboard.vue';

export default {
    name: "Categoria",
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
        categorias: [
            {
                id: 0,
                nome: "",
                descricao: ""
            }
        ],
        IdUsuario: 0
    }),
    mounted() {
        serviceCategoria.listar().then(resposta => {
            this.categorias = resposta.data;
            console.log(this.categorias);
        });
        if(this.$route.params.idUsuario > 0){
            this.IdUsuario = parseInt(this.$route.params.idUsuario);
            console.log(this.IdUsuario);
        }
    },
    methods:{
        edit(id){
            this.$router.push("/dashboard/categoria/ecategoria/"+id);
        },
        del(id){
            serviceCategoria.delete(id).then(resposta => {
                console.log(resposta.data);
            });
            serviceCategoria.listar().then(resposta => {
                this.categorias = resposta.data;
                console.log(this.categorias);
            });
        },
        cadastro(){
            this.$router.push("/dashboard/categoria/ccategoria/"+this.IdUsuario);
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
    .container-list-categoria{
        float: left;
        width: 95%;
        margin: 0.4% 2.0%;
        border: 2px solid black;
        border-radius: 30px;
    }
    .row-categoria{
        float: left;
        width: 100%;
        transition: 1.2s;
        border: 1px solid white;
    }
    .row-categoria:hover{
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
    .create-categoria{
        text-align: center;
        background: white;
        padding: 0.3%;
        margin: 0.4%;
        float: left;
        color: black;
        transition: 1.2s;
        border: 1px solid white;
    }

    .create-categoria:hover{
        cursor: cell;
    }
</style>