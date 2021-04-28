<template>
    <div class="container-cadastro">
        <div class="body-cadastro">
            <div class="container-grupo">
                <div class="row-grupo">
                    <p class="title-grupo">Já possue Grupo cadastrado?</p>
                    <p class="sub-title-grupo">Grupos são necessários para formar uma equipe de usuário no sistema.</p>
                </div>
            </div>
            <div id="app">
                <div class="row-form">
                    <input type="text" id="nomeGrupo" v-model="nomeGrupo" name="nomeGrupo" placeholder="Nome: Company in fitec">
                </div>
                <div class="row-form">
                    <input type="number" id="qtyUsuários" v-model="qtyUsuario" name="qtyUsuario" placeholder="Quantidade de usuários">
                </div>
                <div class="submit-form">
                    <button v-on:click="checkForm()" class="btn-form-grupo">Cadastrar</button>
                </div>
            </div>
        </div>
    </div>
</template>
<script>
import GrupoService from '@/service/grupo.js';

export default {
    name: "Cadastro",
    data(){
        return{
            msg: 'Page do meetup Eduta'
        }
    },
    data: () => ({
        nomeGrupo: null,
        qtyUsuario: Number,
        
    }),
    methods:{
        checkForm(){
            var form = {"nome" : this.nomeGrupo, "qtTotalUser" : this.qtyUsuario};
            GrupoService.save(form).then(resposta => {
                console.log(resposta);
                this.nomeGrupo = '';
                this.qtyUsuario = Number;
            })
        } 
    }   
}
</script>
<style scoped>
.submit-form{
    margin: 5% 2%;
    text-align: left;
}
.container-cadastro{
    float: left;
    width: 50%;
    border-right: 2px solid #d82e52;
    padding: 2.8% 0% 4% 2%;
    margin-top: 3%;
}
.title-grupo{
    text-align: left;
    font-size: 15px;
    font-weight: bold;
}
.sub-title-grupo{
    text-align: left;
    font-size: 13px;
}
.title-cadastro{
    text-align: left;
    line-height: 0;
    float: left;
    padding: 1% 2%;
    width: 77%;
}
.row-form{
    width: 77%;
    margin: 2% 0% 2%;
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
.btn-form-grupo{
    width: 30%;
    background: rgba(230, 189, 0, 0.77);
    border: 1px solid #d82e52;
    opacity: 0.7;
    color: white;
    padding: 1%;
    transition: 0.6s;
}
.btn-form-grupo:hover{
    background: white;
    color: black;
    border: 1px solid rgba(230, 189, 0, 0.77);
}
</style>