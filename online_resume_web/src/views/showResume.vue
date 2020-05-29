<template>
    <div>
      <iframe :src="url" id="iframe" style="width: 100%;" @load="sureHeight"></iframe>
    </div>
</template>

<script>
export default {
  // 返回数据
  data () {
    return {
      userName: this.$route.query.user_name,
      style: this.$route.query.style,
      url: '',
      file_path: ''
    }
  },


  // 模块渲染时执行
  mounted () {

    this.$axios
    .get('/getResumeStyle',{
      params:{
        user_name: this.userName
      }
    })
    .then(function (response) {
      if(response.data != null){
        this.style = response.data.style
        this.file_path = '/static/pdf/web/resumes/' + this.userName+'/' + this.style +'/' + this.userName+'.pdf'
        // 本地请求文件
        let finalFilePath = encodeURIComponent(this.file_path)
        // 跨域请求文件，需走后台代理
        // let filePath2 = encodeURIComponent('/pdf/showPdf?pdfUrl=http://test.hccb.cc/corporBankWXTest/static/123.pdf')
        // pdf文档展示的页面
        this.url = '/static/pdf/web/viewer.html?file=' + finalFilePath
        }
    }.bind(this)).catch(function (error) {
      alert(error);
    });
  },

  // 定义模块测试方法
  methods: {
    // 此方法用于动态确定元素iframe的高度，使展示的pdf文档占满整个屏幕
    sureHeight: function () {
      let element = document.getElementById('iframe')
      // element.style.height = window.screen.height + 'px'
      element.style.height = '1000px'
    },
  }

}
</script>

<style scoped>

</style>
