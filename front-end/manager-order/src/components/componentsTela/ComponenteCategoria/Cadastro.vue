<template>
    <div class="container-cadastro">
        <div class="title-cadastro" >
            <h2>Cadastro / Editar</h2>
        </div>
        <div class="body-cadastro" >
            <div id="app">
                <div class="row-form">
                    <input type="text" id="nome" v-model="nome" name="nome" placeholder="Nome: Garrafa de Vidro">
                </div>
                <div class="row-form">
                    <input type="text" id="descricao" v-model="descricao" name="descricao" placeholder="Descricao">
                </div>
                <div class="submit-form">
                    <button v-on:click="checkForm()" class="btn-form-usuario">Cadastrar</button>
                </div>
            </div>
        </div>
    </div>
</template>
<script>
import CategoriaService from '@/service/categoria.js';
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
        descricao: null,
        idUsuario: 0

    }),
    mixins: [ServiceGlobal],
    methods:{
        checkForm(){
            var form = {
                "nome" : this.nome, 
                "descricao" : this.descricao
            };

            if(this.formStatus == 'EDITA'){
                var idCategoriaPps = this.$route.params.idCategoria;
                CategoriaService.update(form, idCategoriaPps).then(resposta => {
                    console.log(resposta.data);
                });
            }else{
                CategoriaService.save(form).then(resposta => {
                    this.nome = null;
                    this.descricao = null;

                });
            }

            this.$router.push("/dashboard/categoria/"+this.idUsuario);
        }
    },
    computed: {
        computedDisplay: function () {
            return this.diplayStatusBody;
        }
    },
    mounted() {
        
        if(this.formStatus == 'EDITA'){
            var idCategoriaPps = this.$route.params.idCategoria;
            CategoriaService.findById(idCategoriaPps).then(resposta => {
                this.nome = resposta.data.nome;
                this.descricao = resposta.data.descricao;

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