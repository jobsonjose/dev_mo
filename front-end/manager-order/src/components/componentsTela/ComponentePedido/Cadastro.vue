<template>
    <div class="container-cadastro">
        <div class="title-cadastro" >
            <h2>Cadastro</h2>
        </div>
        <div class="body-cadastro" >
            <div id="app">
                <div class="row-form">
                    <input type="text" id="titulo" v-model="titulo" name="nome" placeholder="Titulo">
                </div>
                <div class="row-form">
                    <input type="text" id="descricao" v-model="descricao" name="descricao" placeholder="Descrição">
                </div>
                <div class="row-form">
                    <select id="tipoPedido" v-model="tipoPedido" name="tipoPedido">
                        <option value="ENTRADA">Entrada</option>
                        <option value="SAIDA">Saida</option>
                    </select>
                </div>
                
                <div class="row-form">
                    <input type="date" id="dataCriacao" v-model="dataCriacao" name="dataCriacao">
                </div>
                
                <div class="row-form">
                    <input type="date" id="dataEntrega" v-model="dataEntrega" name="dataEntrega">
                </div>

                <div class="row-form">
                    <select v-model="estoque_id" v-on:change="process()">
                        <option v-for="est in listEstoque" v-bind:key="est.idEstoque" v-bind:value="est.idEstoque">
                            {{ est.nome }}
                        </option>
                    </select>
                </div>
                
                <div class="row-form" style="width: 35%; margin-left: 15%">
                    <b-card title="Selecionar Produto">
                        <b-card-text>
                            <select v-model="idproduto" v-on:change="process()">
                                <option v-for="lprod in listProdutoDTO" v-bind:key="lprod.idproduto" v-bind:value="lprod.idproduto">
                                    {{ lprod.nome }}
                                </option>
                            </select>

                            <input type="number" id="titulo" v-model="quantidade" name="quantidade" placeholder="Total de produtos no pedido">
                        </b-card-text>
                        <template #footer>
                            <button class="btn btn-primary" v-on:click="addList()">Inserir</button>
                        </template>
                    </b-card>
                </div>
                
                <div class="submit-form">
                    <button v-on:click="checkForm()" class="btn-form-usuario">Cadastrar</button>
                </div>
                <div >
                    <div v-for="lp in listproduto" v-bind:key="lp.idproduto" v-bind:value="lp.idproduto">
                        <b-card class="col-md-4" title="Produto" style="float: left; margin-left:2%; margin-bottom: 2%">
                            <b-card-text>
                                <p>{{ lp.idproduto }}</p>
                                <p>{{ lp.quantidade }}</p>
                            </b-card-text>
                            <template #footer>
                                <button class="btn btn-danger" v-on:click="removerList(lp.idproduto)">Remover</button>
                            </template>
                        </b-card>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>
<script>
import EstoqueService from '@/service/estoque.js';
import ServiceGlobal from '@/service/serviceGlobal.js';
import PedidoService from '@/service/pedido.js';
import ProdutoService from '@/service/produto.js';

export default {
    name: "Cadastro",
    data(){
        return{
            msg: 'Page do meetup Eduta'
        }
    },
    props:{
        formStatus: String
    },
    data:() => ({
        titulo: null,
        descricao: null,
        tipoPedido: null,
        dataCriacao: null,
        dataEntrega: null,
        usuario_id: 0,
        estoque_id: 0,
        listproduto: [],
        listEstoque: [],
        listProdutoDTO: [],
        idproduto: 1,
        quantidade: 0

    }),
    mixins: [ServiceGlobal],
    methods:{
        checkForm(){
            var form = {
                "titulo" : this.titulo, 
                "descricao" : this.descricao,
                "tipoPedido" : this.tipoPedido,
                "dataCriacao" : this.dataCriacao,
                "dataEntrega" : this.dataEntrega,
                "usuario_id" : this.usuario_id,
                "estoque_id" : this.estoque_id,
                "listproduto" : this.listproduto
            };
            console.log(this.usuario_id);
            PedidoService.save(form, this.usuario_id).then(resposta => {
                console.log(resposta);
            });

            this.$router.push("/dashboard/pedido/"+this.usuario_id);
        },
        process(){
            ProdutoService.listProdutoPedido(this.estoque_id).then(resposta => {
                this.listProdutoDTO = resposta.data;
            });
        },
        addList(){
            var idprodutoSelected = this.idproduto;
            var quantidadeSelected = this.quantidade;
            var obj = {
                idproduto : idprodutoSelected,
                quantidade : quantidadeSelected  
            };

            this.listproduto.push(obj);
            this.idproduto = 1;
            this.quantidade = 0;
        },
        removerList(index){
            alert(index);
            let produto = this.listproduto.map(lp => lp.idproduto).indexOf(index);
            this.listproduto.splice(produto, 1);
            console.log(this.listproduto);
        }
    },
    computed: {
        computedDisplay: function () {
            return this.diplayStatusBody;
        }
    },
    mounted() {
        this.usuario_id = this.$route.params.idUsuario;

        EstoqueService.listarUsuario(this.usuario_id).then(resposta => {
            this.listEstoque = resposta.data;
        });
    }   
}
</script>
<style scoped>
.submit-form{
    margin: 5% 2%;
    text-align: left;
}
.title-cadastro{
    line-height: 0;
    text-align: left;
    padding: 1% 2%;
}
.container-cadastro{
    float: left;
    width: 70%;
    padding: 0% 1%;
}
.row-form{
    width: 77%;
    margin: 2% 0% 2%;
}
.row-form input, .row-form textarea, .row-form select{
    width: 100%;
    padding: 2% 4%;
    border-radius: 30px;
    border: 2px solid rgba(249, 239, 193, 0.77);
    opacity: 0.7;
    box-shadow: 0 0 0 0;
    outline: 0;
}
.row-form input:hover, .row-form textarea:hover, .row-form select:hover{
    border: 2px solid rgba(230, 189, 0, 0.77);
}
.btn-form-usuario{
    width: 30%;
}
.btn-evento-cadastro{
    width: 77%;
    margin: 4% 11.5%;
}
.btn-form-usuario, .btn-evento-cadastro{
    background: rgba(230, 189, 0, 0.77);
    border: 1px solid #d82e52;
    opacity: 0.7;
    color: white;
    padding: 1%;
    transition: 0.6s;
}
.btn-form-usuario:hover, .btn-evento-cadastro:hover{
    background: white;
    color: black;
    border: 1px solid rgba(230, 189, 0, 0.77);
}

</style>