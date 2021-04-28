<template>
    <div class="container-form-apoiador">
        <div class="title-form">
            <h4>Torne-se um apoiador</h4>
            <h5>Cadastro de apoiador do EDUTA</h5>
        </div>
        <form id="app"
        @submit="checkForm"
        action="https://vuejs.org/"
        method="post">
            <div class="row-form">
                <input type="text" id="nomeApoiador" v-model="nomeApoiador" name="nomeApoiador" placeholder="Nome do apoiador">
            </div>
            <div class="row-form">
                <input type="text" id="emailApoiador" v-model="emailApoiador" name="emailApoiador" placeholder="Email do apoiador">
            </div>
            <div class="row-form">
                <textarea id="descricaoApoiador" placeholder="Quem é o apoiador ?" name="descricaoApoiador" v-model="descricaoApoiador"
                    rows="5" cols="33">
                    Quem é o apoiador ?
                </textarea>
            </div>
            <div class="row-form">
                <textarea id="formacaoApoiador" placeholder="Como está seu histórico acadêmico ?" name="formacaoApoiador" v-model="formacaoApoiador"
                    rows="5" cols="33">
                    Como está seu histórico acadêmico ?
                </textarea>
            </div>
            <div class="row-form">
                <textarea id="carreiraApoiador" placeholder="Como está o histórico profissional ?" name="carreiraApoiador" v-model="carreiraApoiador"
                    rows="5" cols="33">
                    Como está o histórico profissional ?
                </textarea>
            </div>
            <div class="submit-form">
                <button class="btn-form-apoiador">Quero ser Apoiador</button>
            </div>
        </form>
    </div>
</template>
<script>
export default {
    name: 'FormApoiador',
    data(){
        return {
            msg: 'Page do meetup Eduta'
        }
    },
    data:{
        nomeApoiador: String,
        emailApoiador: String,
        descricaoApoiador: String,
        formacaoApoiador: String,
        carreiraApoiador: String
    }    
}
</script>
<style scoped>
.container-form-apoiador{
    background: white;
    padding: 2%;
    width: 50%;
    margin: 2% 25%;
    float: left;
    border-radius: 10%;
}
.row-form{
    width: 50%;
    margin: 2% 25%;
}
.row-form input, .row-form textarea{
    width: 100%;
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

.apoiador{
    padding: 5%;
}

.title-form{
    line-height: 1mm;
    margin: 5%;
}

.submit-form{
    margin: 2%;
}
.btn-form-apoiador{
    width: 25%;
    background: white;
    color: black;
    translate: 1s;
    padding: 2%;
    transition: 0.6s;
}

.btn-form-apoiador:hover{
    background: rgba(230, 189, 0, 0.77);
    color: white;
    transform: scale(1.1);
}

</style>