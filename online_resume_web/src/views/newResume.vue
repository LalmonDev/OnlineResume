<template>
  <div id="index">
    <div class="wrap_conter">
      <div class="demo-spin-col">
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
                    <el-select v-model="formValidate.sex" style="width:200px" placeholder="性别">
                        <el-option
                          v-for="item in sexs"
                          :key="item.value"
                          :label="item.label"
                          :value="item.value">
                        </el-option>
                      </el-select>
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
              <!-- <FormItem label="出生年月" style="width: 200px" prop="date">
                  <DatePicker type="date"  @on-change="formValidate.date=$event" :value="formatTime" style="width: 200px" placeholder="请选择" v-model="formValidate.date" ></DatePicker>
              </FormItem> -->
              <FormItem label="出生年月" style="width: 200px" prop="date">
              <el-date-picker
                    v-model="formValidate.date"
                    type="date"
                    placeholder="选择日期"
                    format="yyyy 年 MM 月 dd 日"
                    value-format="yyyy-MM-dd"
                    style="width: 200px"
                    >
              </el-date-picker>
              </FormItem>
          </Col>
          <Col span="4" offset="4">
            <FormItem label="政治面貌" style="width: 200px" prop="face">
                <Input v-model="formValidate.face" style="width: 200px" placeholder="政治面貌"></Input>
            </FormItem>
          </Col>
          <Col span="4" offset="4">
            <FormItem label="婚姻状况" prop="marry">
            <el-select v-model="formValidate.marry" style="width:200px" placeholder="请选择">
                <el-option
                  v-for="item in options"
                  :key="item.value"
                  :label="item.label"
                  :value="item.value">
                </el-option>
              </el-select>
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
                  <FormItem label="起止日期" style="width: 0px">
                    <el-date-picker
                          v-model="formValidate.study_start_day"
                          type="date"
                          placeholder="开始日期"
                          format="yyyy 年 MM 月 dd 日"
                          value-format="yyyy-MM-dd"
                          :picker-options="pickerOptionsStart"
                          style="width: 200px"
                          >
                  </el-date-picker>
                  </FormItem>
                </Col>

               <Col span="2" offset="5">
                    <el-date-picker
                          v-model="formValidate.study_stop_day"
                          type="date"
                          placeholder="结束日期"
                          format="yyyy 年 MM 月 dd 日"
                          value-format="yyyy-MM-dd"
                          :picker-options="pickerOptionsEnd"
                          style="width: 200px"
                          >
                  </el-date-picker>

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

        <Divider>简历模板选择</Divider><br>
        <div>
            <el-radio-group v-model="style" size="small">
                  <el-radio label="style1" border>模板1</el-radio>
                  <el-radio label="style2" border>模板2</el-radio>
                </el-radio-group>
          </div>
        <br>
        <br>
          <FormItem>
              <Button type="primary" @click="handleSubmit('formValidate')">提交</Button>
              <Button @click="handleReset('formValidate')" style="margin-left: 8px">重置</Button>
          </FormItem>
          <br>
      </Form>
      </ul>
    </div>
    </div>
    </div>
</template>
<script>
    export default {
        data () {
            return {
              userName: this.$route.query.user_name,
              style: 'style1',
              pickerOptionsStart: {
                                   disabledDate: time => {
                                          if (this.formValidate.study_stop_day) {
                                               return time.getTime() > new Date(this.formValidate.study_stop_day).getTime()
                                         }
                                  }
                           },
              pickerOptionsEnd: {
                       disabledDate: time => {
                             if (this.formValidate.study_start_day) {
                                     return time.getTime() < new Date(this.formValidate.study_start_day).getTime() - 86400000
                             }
                        }
              },


              options: [{
                        value: '未婚',
                        label: '未婚'
                      }, {
                        value: '已婚',
                        label: '已婚'
                      }, {
                        value: '离异',
                        label: '离异'
                      }],

                sexs: [{
                          value: '男',
                          label: '男'
                        }, {
                          value: '女',
                          label: '女'
                        }],

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
                ruleValidate: {
                    name: [
                        { required: true, message: '姓名不能为空', trigger: 'blur' }
                    ],
            //         sex: [
            //             { required: true, message: '性别不能为空', trigger: 'blur' }
            //         ],
            //         nation: [
            //             { required: true, message: '民族不能为空', trigger: 'blur' }
            //         ],
            //         date: [
            //             { required: true, type: 'date', message: '日期不能为空', trigger: 'change' }
            //         ],
            //         face: [
            //             { required: true, message: '政治面貌不能为空', trigger: 'blur' }
            //         ],
            //         marry: [
            //             { required: true, message: '婚姻状况不能为空', trigger: 'change' }
            //         ],
                    home: [
                        { required: true, message: '籍贯不能为空', trigger: 'blur' }
                    ],
                    phone: [
                        { required: true, message: '联系电话不能为空', trigger: 'blur' }
                    ],
                    mail: [
                        { required: true, message: '邮箱不能为空', trigger: 'blur' },
                        { type:'email', message: '输入正确的邮箱格式', trigger: 'blur' }
                    ],
                    job: [
                        { required: true, message: '求职岗位不能为空', trigger: 'blur' }
                    ],
                    city: [
                        { required: true, message: '意向城市不能为空', trigger: 'blur' }
                    ],
            //         money: [
            //             { required: true, message: '期望薪资不能为空', trigger: 'blur' }
            //         ],
            //         study_start_day: [
            //             { required: true, type: 'date', message: '入学日期不能为空', trigger: 'change' }
            //         ],
            //         study_stop_day: [
            //             { required: true, type: 'date', message: '毕业日期不能为空', trigger: 'change' }
            //         ],
                    school: [
                        { required: true, message: '学校不能为空', trigger: 'blur' }
                    ],
                    major: [
                        { required: true, message: '专业不能为空', trigger: 'blur' }
                    ],
                    degree: [
                        { required: true, message: '学位不能为空', trigger: 'blur' }
                    ]
                }
            }
        },

        mounted(){
        	/*页面初始化调用方法*/
            this.getResumeInfo();
        },

        methods: {
            getResumeInfo(){
              this.$axios
              .get('/getResume',{
                params: {
                  user_name: this.userName
                  }
              })
              .then(function (response) {
                  this.formValidate.name=response.data.name,
                  this.formValidate.sex=response.data.sex,
                  this.formValidate.nation=response.data.nation,
                  this.formValidate.date=response.data.date,
                  this.formValidate.face=response.data.face,
                  this.formValidate.marry=response.data.marry,
                  this.formValidate.home=response.data.home,
                  this.formValidate.phone=response.data.phone.toString(),
                  this.formValidate.mail=response.data.mail,
                  this.formValidate.job=response.data.job,
                  this.formValidate.city=response.data.city,
                  this.formValidate.money=response.data.money,
                  this.formValidate.study_start_day=response.data.study_start_day,
                  this.formValidate.study_stop_day=response.data.study_stop_day,
                  this.formValidate.school=response.data.school,
                  this.formValidate.major=response.data.major,
                  this.formValidate.degree=response.data.degree,
                  this.formValidate.school_descrip=response.data.school_descrip,
                  this.formValidate.skill=response.data.skill,
                  this.formValidate.job_experience=response.data.job_experience,
                  this.formValidate.school_experience=response.data.school_experience,
                  this.formValidate.award=response.data.award,
                  this.formValidate.interest=response.data.interest,
                  this.formValidate.evaluate=response.data.evaluate

              }.bind(this)).catch(function (error) {
                alert(error);
              });
            },

            handleSubmit (name) {
              this.$Spin.show();
                this.$refs[name].validate((valid) => {
                    if (valid) {
                      var data = {
                        'name': this.formValidate.name,
                        'sex': this.formValidate.sex,
                        'nation': this.formValidate.nation,
                        'date': this.formValidate.date,
                        'face': this.formValidate.face,
                        'marry': this.formValidate.marry,
                        'home': this.formValidate.home,
                        'phone': this.formValidate.phone,
                        'mail': this.formValidate.mail,
                        'job': this.formValidate.job,
                        'city': this.formValidate.city,
                        'money': this.formValidate.money,
                        'study_start_day': this.formValidate.study_start_day,
                        'study_stop_day': this.formValidate.study_stop_day,
                        'school': this.formValidate.school,
                        'major': this.formValidate.major,
                        'degree': this.formValidate.degree,
                        'school_descrip': this.formValidate.school_descrip,
                        'skill': this.formValidate.skill,
                        'job_experience': this.formValidate.job_experience,
                        'school_experience': this.formValidate.school_experience,
                        'award': this.formValidate.award,
                        'interest': this.formValidate.interest,
                        'evaluate': this.formValidate.evaluate
                      };
                        this.$axios
                          // .post('/newResume/'+ this.userName, this.formValidate)
                          .post('/newResume/'+ this.userName + '&' + this.style, data)
                          .then(response => {
                            this.$Message.success('Success!');
                            this.$Spin.hide();
                            let code = response.data.code
                            if(code == 200){
                              this.$router.replace({path:'/showResume',query:{user_name:this.userName,style:this.style}})
                            }else if(code == 400){
                              this.$Message.error('Fail!')
                              this.$Spin.hide();
                            }
                          })
                          .catch(failResponse => {
                          })
                    } else {
                      this.$Spin.hide();
                      this.$Message.error('Fail!')
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
  .demo-spin-icon-load{
          animation: ani-demo-spin 1s linear infinite;
      }
  .demo-spin-col{
    height: 100px;
    position: relative;
    border: 1px solid #ffffff;
  }
</style>
