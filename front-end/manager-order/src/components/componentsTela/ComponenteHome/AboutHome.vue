<template>
    <div class="container-about">
        <div class="img-about">
            <img src="https://cio.com.br/wp-content/uploads/2019/12/os-livros-tecnologia-ler-2020.jpg" alt="">
        </div>
        <div class="document-about">
            <div class="title-about">
                <h2>Olá, deseja nos conhecer ?</h2>
                <h3>como trabalhamos ?</h3>
            </div>
            <div class="body-about">
                <p>Lorem ipsum dolor sit amet consectetur, adipisicing elit. Dicta consequuntur ullam, 
                    accusamus cum officiis sint sequi, adipisci odit recusandae cupiditate excepturi 
                    aliquid explicabo! Illo dolor quis quo, eos adipisci dolorum.</p>
                <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Tempora ab nam doloribus totam provident at 
                    laborum iste repudiandae ipsum veniam, ut odio ullam voluptas mollitia itaque, 
                    vero rem omnis neque?</p>
                <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Perferendis neque, vitae amet 
                    magnam dolorum dolorem possimus? Libero optio accusamus deserunt, 
                    iste aliquam provident, modi culpa iure tempora voluptatem, suscipit nam!.</p>
            </div>
        </div>
    </div>
</template>
<script>
export default {
    name: 'AboutHome',
    data(){
        return{
            msg:'Page do meetup Eduta'
        }
    }
}
</script>
<style scoped>
.container-about{
    background: #d82e52;
    float: left;
    width: 100%;
    margin-bottom: 5%;
}
.img-about{
    float: left;
    width: 50%;
    padding: 2%;
}
.img-about img{
    width: 100%;
}
.document-about{
    float: left;
    width: 40%;
    padding: 2%;
    color: white;
}
.title-about h2, h3{
    margin: 0.5% !important;
}


</style>