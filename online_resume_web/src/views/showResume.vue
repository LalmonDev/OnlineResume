<template>
  <div>
    <Row type="flex" style="position:absolute;left:0;width:100%;">
      <Col span="4" class="layout-menu-left">
        <Button style="width: 45%" type="primary" @click="style1()">模板1</Button>
      </Col>
      <Col span="4">
        <Button style="width: 45%" type="primary" @click="style2()">模板2</Button>
      </Col>
    </Row>
    <div>
      <iframe :src="url" id="iframe" style="width: 100%;" @load="sureHeight"></iframe>
    </div>
  </div>
</template>

<script>
export default {
  // 返回数据
  data () {
    return {
      userName: this.$route.query.user_name,
      url: '',
      file_path: ''
    }
  },

  // 模块创建时执行
  created () {
    this.file_path = 'online_resume_web/static/pdf/resumes/' + this.userName
  },

  // 模块渲染时执行
  mounted () {
    // 本地请求文件
    let finalFilePath = encodeURIComponent(this.file_path)
    // 跨域请求文件，需走后台代理
    // let filePath2 = encodeURIComponent('/pdf/showPdf?pdfUrl=http://test.hccb.cc/corporBankWXTest/static/123.pdf')
    // pdf文档展示的页面
    this.url = '/static/pdf/web/viewer.html?file=' + finalFilePath
  },

  // 定义模块测试方法
  methods: {
    // 此方法用于动态确定元素iframe的高度，使展示的pdf文档占满整个屏幕
    sureHeight: function () {
      let element = document.getElementById('iframe')
      // element.style.height = window.screen.height + 'px'
      element.style.height = '1000px'
    },

    style1(){
      this.$Spin.show();
      this.$axios
        .get('/rebuildResume',{
          params: {
            user_name: this.userName,
            style: 'style1'
          }
        })
        .then(function (response) {
          this.$Spin.hide();
          let code = response.data.code
          if(code != 200){
            this.$Message.error('Fail!')
          }
        }.bind(this)).catch(function (error) {
        alert(error);
      });
    },

    style2(){
      this.$Spin.show();
      this.$axios
        .get('/rebuildResume',{
          params: {
            user_name: this.userName,
            style: 'style2'
          }
        })
        .then(function (response) {
          this.$Spin.hide();
          let code = response.data.code
          if(code != 200){
            this.$Message.error('Fail!')
          }
        }.bind(this)).catch(function (error) {
        alert(error);
      });
    },
  }
}
</script>

<style scoped>

</style>
