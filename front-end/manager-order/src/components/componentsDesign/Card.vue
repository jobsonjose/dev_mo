<template>
    <div class="container-card">
        <div class="header-card">
            <h4>{{ titulo }}</h4>
        </div>
        <div class="body-card">
            <img class="image-card" :src="image">
            <p>{{ description }}</p>
        </div>
    </div>
</template>
<script>
export default {
   name: "Card",
   props:{
       titulo: { type: String, default: "Titulo Teste"},
       description: { type: String, default: "Titulo Teste"},
       image: String
   },
   data () {
    return {
      msg: 'Page do meetup Eduta'
    }
  } 
}
</script>
<style scoped>
.container-card{
    width: 22%;
    margin: 3% 3.5%;
    box-shadow: 1px 10px 15px rgba(50, 50, 50, 0.77);
    padding: 2%;
    float: left;
    transition: 1.2s
}
.container-card:hover{
    transform: scale(1,1);
    box-shadow: 1px 10px 15px rgba(247, 223, 106, 0.77);
}
.header-card{
    text-align: left;
    color: #d82e52;
}
.body-card{
    font-size: 10px;
    font-family: 'Lucida Sans', 'Lucida Sans Regular', 'Lucida Grande', 
    'Lucida Sans Unicode', Geneva, Verdana, sans-serif;
    text-align: left;
}
.footer-card{
    margin-top: 5%;
}
.btn-footer{
    float: right;
    border-radius: 30px;
    background: #d82e52;
    color: white;
    border: none;
    padding: 2%;
}
.image-card{
    width: 100%;
}
</style>