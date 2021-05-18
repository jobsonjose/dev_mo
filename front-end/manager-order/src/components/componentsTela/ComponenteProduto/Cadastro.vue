<template>
    <div class="container-cadastro">
        <div class="title-cadastro" >
            <h2>Cadastro / Editar</h2>
        </div>
        <div class="body-cadastro" >
            <div id="app">
                <div class="row-form">
                    <input type="text" id="nome" v-model="nome" name="nome" placeholder="Nome: Leite">
                </div>
                <div class="row-form">
                    <input type="number" id="valor" v-model="valor" name="valor" placeholder="Valor: valor > 0">
                </div>
                <div class="row-form">
                    <input type="text" id="descricao" v-model="descricao" name="descricao" placeholder="Descricao">
                </div>
                <div class="row-form">
                    <input type="number" id="quantidade" v-model="quantidade" name="quantidade" placeholder="Quantidade inicial">
                </div>
                <div class="row-form">
                    <select v-model="categoria">
                        <option v-for="cat in categorias" v-bind:key="cat.id" v-bind:value="cat.id">
                            {{ cat.nome }}
                        </option>
                    </select>
                </div>
                <div class="row-form">
                    <select v-model="estoque">
                        <option v-for="est in estoques" v-bind:key="est.id" v-bind:value="est.id">
                            {{ est.nome }}
                        </option>
                    </select>
                </div>

                <div class="submit-form">
                    <button v-on:click="checkForm()" class="btn-form-usuario">Cadastrar</button>
                </div>
            </div>
        </div>
    </div>
</template>
<script>
import ProdutoService from '@/service/produto.js';
import CategoriaService from '@/service/categoria.js';
import EstoqueService from '@/service/estoque.js';
import ServiceGlobal from '@/service/serviceGlobal.js';

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
        nome: null,
        valor: null,
        descricao: null,
        quantidade: null,
        idUsuario: null,
        idCategoria: null,
        idEstoque: null,
        categorias: [],
        estoques: [],
        estoque: null,
        categoria: null

    }),
    mixins: [ServiceGlobal],
    methods:{
        checkForm(){
            var form = {
                "nome" : this.nome, 
                "valor" : this.valor,
                "descricao" : this.descricao,
                "quantidade" : this.quantidade
            };
            this.idEstoque = this.estoque;
            this.idCategoria = this.categoria;

            if(this.formStatus == 'EDITA'){
                var idProdutoPps = this.$route.params.idProduto;
                ProdutoService.update(form, this.idUsuario, this.idEstoque, this.idCategoria, idProdutoPps).then(resposta => {
                    console.log(resposta.data);
                });
            }else{
                ProdutoService.save(form, this.idUsuario, this.idEstoque, this.idCategoria).then(resposta => {
                    this.nome = null;
                    this.valor = null;
                    this.descricao = null;
                    this.quantidade = null;
                    this.estoque = null;
                    this.categoria = null;

                });
            }

            this.$router.push("/dashboard/produto/"+this.idUsuario);
        }
    },
    computed: {
        computedDisplay: function () {
            return this.diplayStatusBody;
        }
    },
    mounted() {
        CategoriaService.listar().then(resposta => {
            this.categorias = resposta.data;
        });

        EstoqueService.listar().then(resposta => {
            this.estoques = resposta.data;
        });

        if(this.formStatus == 'EDITA'){
            var idProdutoPps = this.$route.params.idProduto;
            ProdutoService.byId(idProdutoPps).then(resposta => {
                this.nome = resposta.data.nome;
                this.descricao = resposta.data.descricao;
                this.valor = resposta.data.valor;
                this.quantidade = resposta.data.quantidade;
                this.estoque = resposta.data.idEstoque;
                this.categoria = resposta.data.idCategoria;
                this.idUsuario = resposta.data.idUsuario;

            });
        }else{
            this.idUsuario = this.$route.params.idUsuario;
        }
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