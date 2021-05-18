<template>
    <div class="container-cadastro">
        <div class="body-cadastro">
            <div class="row-form">
                <input type="text" id="nomeBusca" v-model="nomeBusca" name="nomeBusca" placeholder="Busca pelo grupo">
                <button class="btn-busca-grupo" v-on:click="checkForm()">Buscar</button>
            </div>
            <table style="width: 100%; margin: 0%;" id="table-grupos">
                <thead>
                    <tr class="row-heard-table">
                    <th>Nome</th>
                    <th>Quantidade</th>
                    </tr>
                </thead>
                <tbody>
                    <tr class="row-heard-table" v-for="grupo in grupos">
                        <td>{{grupo.nome}}</td>
                        <td>{{grupo.qtTotalUser}}</td>
                    </tr>
                </tbody>
            </table>
        </div>
    </div>
</template>
<script>
import GrupoService from '@/service/grupo.js';

export default {
    name: "Listagem",
    data(){
        return{
            msg: "Page do meetup Eduta"
        }
    },
    data: () => ({
        grupos: [
            {
                nome: 'jobson',
                qtTotalUser: 30
            }
        ],
        nomeBusca: ''
    }),
    methods:{
        checkForm(){
            return 0;
        }
    },
    mounted() {
        GrupoService.listar().then(resposta => {
            this.grupos = resposta.data;
        })
    }
}
</script>
<style scoped>
    .container-cadastro{
        float: left;
        width: 45%;
        padding: 5% 1%;
    }
    .row-form{
        width: 77%;
        margin: 2% 0% 2%;
    }
    .row-form input, .row-form textarea{
        width: 70%;
        padding: 2% 4%;
        border-radius: 30px;
        border: 2px solid rgba(249, 239, 193, 0.77);
        opacity: 0.7;
        box-shadow: 0 0 0 0;
        outline: 0;
    }
    .row-form input:hover, .row-form textarea:hover{
        border: 2px solid rgba(230, 189, 0, 0.77);
    }
    .btn-form-usuario{
        width: 30%;
    }
    .btn-busca-grupo{
        background: rgba(230, 189, 0, 0.77);
        border: 1px solid #d82e52;
        opacity: 0.7;
        color: white;
        padding: 2%;
        transition: 0.6s;
    }

    .btn-busca-grupo:hover{
        background: white;
        color: black;
        border: 1px solid rgba(230, 189, 0, 0.77);
    }
    .row-heard-table th{
        padding: 10% 10% 2% 2%;
        font-weight: 500;
        width: 40%;
        text-align: left;
        color: gray;
        border-bottom: 1px solid black;
    }
    .row-heard-table td{
        text-align: left;
        padding: 2%
    }

</style>