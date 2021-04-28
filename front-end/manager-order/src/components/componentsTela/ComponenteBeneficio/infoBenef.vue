<template>
    <div class="container-info">
        <div class="row-title">
                <p style="margin: 0%">{{ titulo }}</p>
            </div>
            <div class="row-des">
                <p style="margin: 0%">{{ description }}</p>
            </div>
    </div>
</template>
<script>
export default {
    name: "infoBenef",
    data(){
        return {
            msg: 'Page do meetup Eduta'
        }
    },
    props:{
        titulo: { type: String, default: "Titulo Teste"},
        description: { type: String, default: "Titulo Teste"},
    }
}
</script>
<style>
    .container-info{
        margin: 2%;
    }
    .row-title{
        text-align: left;
        margin: 0% 1%;
        padding: 1%;
        border-bottom: 1px solid black;
        background: #d82e52;
        color: white;
    }
    .row-des{
        text-align: left;
        margin: 0% 1% 1%;
        background: #d8c4c4;
        padding: 2%;
    }
</style>