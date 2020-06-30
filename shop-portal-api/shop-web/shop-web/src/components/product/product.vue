<template>
  <div>
    欢迎来到飞狐坑钱页面
  </div>
</template>
<script>
  export default {
    data(){
      return {}
    },
    created(){
      this.queryProduct();
    },
    methods:{
      queryProduct(){
        this.$http({
          url:"/pruductService/products",
          method: "get",
        }).then(result=>{
        })
      }
    }
  }
</script>
<style>

</style>
