<template>
  <div id="index">
    <div class="wrap_conter">
      <ul>
         <Divider>基本信息</Divider>
        <br>
      <Form ref="formValidate" :model="formValidate" :rules="ruleValidate" :label-width="80">
          <Row>
              <Col span="4" >
                  <FormItem label="姓名" prop="name">
                      <Input v-model="formValidate.name" style="width: 200px" placeholder="姓名"></Input>
                  </FormItem>
              </Col>
              <Col span="4" offset="4" >
                <FormItem label="性别" prop="sex">
                    <Input v-model="formValidate.sex" style="width: 200px" placeholder="性别"></Input>
                </FormItem>
              </Col>
              <Col span="4" offset="4">
               <FormItem label="民族" prop="nation" style="width:200px">
                  <Input v-model="formValidate.nation" style="width: 200px" placeholder="民族"></Input>
               </FormItem>
               </Col>
          </Row>

        <Row>
          <Col span="4">
              <FormItem label="出生年月" style="width: 200px" prop="date">
                  <DatePicker type="date"  @on-change="formValidate.date=$event" :value="formatTime" style="width: 200px" placeholder="请选择" v-model="formValidate.date" ></DatePicker>
              </FormItem>
          </Col>
          <Col span="4" offset="4">
            <FormItem label="政治面貌" style="width: 200px" prop="face">
                <Input v-model="formValidate.face" style="width: 200px" placeholder="政治面貌"></Input>
            </FormItem>
          </Col>
          <Col span="4" offset="4">
            <FormItem label="婚姻状况" prop="marry">
            <Select v-model="formValidate.marry" style="width:200px" >
                <Option value="已婚" >已婚</Option>
                <Option value="未婚">未婚</Option>
                <Option value="离异">离异</Option>
            </Select>
            </FormItem>
          </Col>
         </Row>

         <Row>
           <Col span="4">
           <FormItem label="籍贯" prop="home" style="width:200px">
              <Input v-model="formValidate.home" style="width: 200px" placeholder="籍贯"></Input>
           </FormItem>
           </Col>
           <Col span="4" offset="4">
            <FormItem label="联系电话" prop="phone" style="width:200px">
               <Input v-model="formValidate.phone" style="width: 200px" placeholder="联系电话"></Input>
            </FormItem>
            </Col>
            <Col span="4" offset="4" >
              <FormItem label="邮箱" prop="mail">
                  <Input v-model="formValidate.mail" style="width: 200px" placeholder="邮箱 "></Input>
              </FormItem>
            </Col>
           </Row>

           <Divider>求职意向</Divider><br>
           <Row>
             <Col span="4">
             <FormItem label="求职岗位" prop="job" style="width:200px">
                <Input v-model="formValidate.job" style="width: 200px" placeholder="求职岗位"></Input>
             </FormItem>
             </Col>
             <Col span="4" offset="4">
              <FormItem label="意向城市" prop="city" style="width:200px">
                 <Input v-model="formValidate.city" style="width: 200px" placeholder="意向城市"></Input>
              </FormItem>
              </Col>
              <Col span="4" offset="4" >
                <FormItem label="期望薪资" prop="money">
                    <Input v-model="formValidate.money" style="width: 200px" placeholder="期望薪资 "></Input>
                </FormItem>
              </Col>
             </Row>

          <Divider>教育背景</Divider><br>
          <Row>
                <Col span="2">
                  <FormItem label="起止日期" prop="study_start_day">
                    <DatePicker type="date" @on-change="formValidate.study_start_day=$event" :value="formatTime" style="width: 110px" placeholder="入学年月" v-model="formValidate.study_start_day"></DatePicker>
                  </FormItem>
                </Col>
                <Col span="2" offset="1">
                  <FormItem prop="study_stop_day">
                    <DatePicker type="date" @on-change="formValidate.study_stop_day=$event" :value="formatTime" style="width: 110px" placeholder="毕业年月" v-model="formValidate.study_stop_day"></DatePicker>
                  </FormItem>
                </Col>
              </Row>

          <Row>
            <Col span="4">
            <FormItem label="学校" prop="school" style="width:200px">
               <Input v-model="formValidate.school" style="width: 200px" placeholder="学校"></Input>
            </FormItem>
            </Col>
            <Col span="4" offset="4">
             <FormItem label="专业" prop="major" style="width:200px">
                <Input v-model="formValidate.major" style="width: 200px" placeholder="专业"></Input>
             </FormItem>
             </Col>
             <Col span="4" offset="4" >
               <FormItem label="学位" prop="degree">
                   <Input v-model="formValidate.degree" style="width: 200px" placeholder="学位 "></Input>
               </FormItem>
             </Col>
            </Row>
            <Row>
              <FormItem label="描述" style="width:1000px" prop="school_descrip" >
                <Input v-model="formValidate.school_descrip" type="textarea" :autosize="{minRows: 2,maxRows: 5}" placeholder="请输入"></Input>
              </FormItem>
            </Row>

          <Divider>学校情况</Divider><br>
          <FormItem label="技能特长" style="width:1000px" prop="skill">
            <Input v-model="formValidate.skill" type="textarea" :autosize="{minRows: 2,maxRows: 5}" placeholder="请输入"></Input>
          </FormItem>
          <FormItem label="实习经历" style="width:1000px" prop="job_experience">
            <Input v-model="formValidate.job_experience" type="textarea" :autosize="{minRows: 2,maxRows: 5}" placeholder="请输入"></Input>
          </FormItem>
           <FormItem label="校园经历" style="width:1000px" prop="school_experience">
             <Input v-model="formValidate.school_experience" type="textarea" :autosize="{minRows: 2,maxRows: 5}" placeholder="请输入"></Input>
           </FormItem>
           <FormItem label="获奖情况" style="width:1000px" prop="award">
             <Input v-model="formValidate.award" type="textarea" :autosize="{minRows: 2,maxRows: 5}" placeholder="请输入"></Input>
           </FormItem>

           <Divider>个人情况</Divider><br>
           <FormItem label="兴趣爱好" style="width:1000px" prop="interest">
             <Input v-model="formValidate.interest" type="textarea" :autosize="{minRows: 2,maxRows: 5}" placeholder="请输入"></Input>
           </FormItem>
           <FormItem label="自我评价" style="width:1000px" prop="evaluate">
             <Input v-model="formValidate.evaluate" type="textarea" :autosize="{minRows: 2,maxRows: 5}" placeholder="请输入"></Input>
           </FormItem>


          <FormItem>
              <Button type="primary" @click="handleSubmit('formValidate')">提交</Button>
              <Button @click="handleReset('formValidate')" style="margin-left: 8px">重置</Button>
          </FormItem>
          <br>
      </Form>
      </ul>
    </div>
    </div>
</template>
<script>
    export default {
        data () {
            return {
              userName: this.$route.query.user_name,
              formatTime: '2019-03-10',

                formValidate: {
                    name: '',
                    sex: '',
                    nation: '',
                    date: '',
                    face:'',
                    marry: '',
                    home: '',
                    phone: '',
                    mail: '',
                    job: '',
                    city: '',
                    money: '',
                    study_start_day: '',
                    study_stop_day: '',
                    school: '',
                    major: '',
                    degree: '',
                    school_descrip: '',
                    skill: '',
                    job_experience: '',
                    school_experience: '',
                    award: '',
                    interest: '',
                    evaluate: '',
                },
                // ruleValidate: {
                //     name: [
                //         { required: true, message: '姓名不能为空', trigger: 'blur' }
                //     ],
                //     sex: [
                //         { required: true, message: '性别不能为空', trigger: 'blur' }
                //     ],
                //     nation: [
                //         { required: true, message: '民族不能为空', trigger: 'blur' }
                //     ],
                //     date: [
                //         { required: true, type: 'date', message: '日期不能为空', trigger: 'change' }
                //     ],
                //     face: [
                //         { required: true, message: '政治面貌不能为空', trigger: 'blur' }
                //     ],
                //     marry: [
                //         { required: true, message: '婚姻状况不能为空', trigger: 'change' }
                //     ],
                //     home: [
                //         { required: true, message: '籍贯不能为空', trigger: 'blur' }
                //     ],
                //     phone: [
                //         { required: true, message: '联系电话不能为空', trigger: 'blur' }
                //     ],
                //     mail: [
                //         { required: true, message: '邮箱不能为空', trigger: 'blur' },
                //     ],
                //     job: [
                //         { required: true, message: '求职岗位不能为空', trigger: 'blur' }
                //     ],
                //     city: [
                //         { required: true, message: '意向城市不能为空', trigger: 'blur' }
                //     ],
                //     money: [
                //         { required: true, message: '期望薪资不能为空', trigger: 'blur' }
                //     ],
                //     study_start_day: [
                //         { required: true, type: 'date', message: '入学日期不能为空', trigger: 'change' }
                //     ],
                //     study_stop_day: [
                //         { required: true, type: 'date', message: '毕业日期不能为空', trigger: 'change' }
                //     ],
                //     school: [
                //         { required: true, message: '学校不能为空', trigger: 'blur' }
                //     ],
                //     major: [
                //         { required: true, message: '专业不能为空', trigger: 'blur' }
                //     ],
                //     degree: [
                //         { required: true, message: '学位不能为空', trigger: 'blur' }
                //     ]
                // }
            }
        },
        methods: {
            handleSubmit (name) {
                this.$refs[name].validate((valid) => {
                    if (valid) {
                        this.$Message.success('Success!');

                        this.$axios
                          .post('/newResume/'+ this.userName, this.formValidate)
                          .then(response => {
                            let code = response.data.code
                            if(code == 200){
                              this.$router.replace({path:'/showResume',query:{user_name:this.userName}})
                            }else if(code == 400){
                              alert("return 400")
                            }
                          })
                          .catch(failResponse => {
                          })

                        alert(this.userName)
                    } else {
                        this.$Message.error('Fail!');
                        alert(this.userName)
                    }
                })
            },
            handleReset (name) {
                this.$refs[name].resetFields();
            },

        }
    }
</script>

<style>
  #index_pc_bj{width:100%;height:100%;background-size:cover;overflow: hidden;background-position:center center;box-shadow: 0 0px 3px rgba(0,0,0,.5);text-align: center;}
  .wrap_conter ul{position:relative;width:1100px;border:5px solid rgba(255,255,255,0.3);border-radius:5px;box-shadow: 0 0px 5px rgba(0,0,0,.2); margin-top: 1%; margin-left: 8%; text-align:center;}
  .wrap_conter li{text-align:center;color:#fff;font-size:12px;line-height:30px; padding:0 25px 5px 25px;width: 100%;}
  .pc-hign{height:75px;display: inline-table;}
  .wrap_conter li dl{width:100%;}
  .name-password-error{
      padding-bottom: 2px;
      text-align: left;
      line-height: 1;
      color: #ed3f14;
  }
</style>
