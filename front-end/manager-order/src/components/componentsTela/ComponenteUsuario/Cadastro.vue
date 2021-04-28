<template>
    <div class="container-cadastro">
        <div class="title-cadastro" >
            <h4>Cadastrar no Manager Order</h4>
            <h5>Deseja ser membro de nosso sistema?</h5>
        </div>
        <div class="body-cadastro" >
            <div id="app">
                <div class="row-form">
                    <input type="text" id="nomeUsuario" v-model="nomeUsuario" name="nomeUsuario" placeholder="Nome: Jobson Jose">
                </div>
                <div class="row-form">
                    <input type="text" id="emailUsuario" v-model="emailUsuario" name="emailUsuario" placeholder="Email: jjortb@gmail.com">
                </div>
                <div class="row-form">
                    <input type="text" id="CPF" v-model="CPF" name="CPF" placeholder="CPF">
                </div>
                <div class="row-form">
                    <input type="password" id="senhaUsuario" v-model="senhaUsuario" name="senhaUsuario" placeholder="**************">
                </div>
                <div class="row-form">
                    <input type="text" id="Phone" v-model="Phone" name="Phone" placeholder="(XX) XXXX-XXXX">
                </div>
                <div class="row-form">
                    <select v-model="grupoSelected">
                        <option v-for="grupo in grupos" v-bind:value="grupo.id">
                            {{ grupo.nome }}
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
import GrupoService from '@/service/grupo.js';
import UsuarioService from '@/service/usuario.js';

export default {
    name: "Cadastro",
    data(){
        return{
            msg: 'Page do meetup Eduta'
        }
    },
    data:() => ({
        nomeUsuario: null,
        emailUsuario: null,
        senhaUsuario: null,
        CPF: null,
        Phone: null,
        grupoSelected: null,
        grupos: [],
        styleObject: {
            color: 'red',
            fontSize: '13px'
        }
    }),
    methods:{
        checkForm(){
            var form = {"nome" : this.nomeUsuario, "email" : this.emailUsuario, "senha" : this.senhaUsuario, "cpf" : this.CPF};
            
            UsuarioService.save(form, this.grupoSelected).then(resposta => {
                this.nomeUsuario = null;
                this.emailUsuario = null;
                this.senhaUsuario = null;
                this.CPF = null;
                this.Phone = null;
                this.grupoSelected = null;

            });
        }
    },
    computed: {
        computedDisplay: function () {
            return this.diplayStatusBody;
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
    width: 45%;
    padding: 5% 1%;
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