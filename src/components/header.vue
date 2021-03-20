<template>
  <div>
    <header class="header">
      <h2>Welcome to my blog</h2>
      <div id="">
        <router-link to="/">Home</router-link> |
        <router-link to="/about">About</router-link> |
        <el-button type="text" @click="dialogVisible = true">Login</el-button>
      </div>
    </header>
    <el-dialog title="登录" :visible.sync="dialogVisible" width="30%">
      <el-form
        :model="ruleForm"
        status-icon
        ref="ruleForm"
        label-width="100px"
        class="demo-ruleForm"
      >
        <el-form-item label="用户名">
          <el-input type="name" v-model="ruleForm.username" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="密码">
          <el-input type="password" v-model="ruleForm.password" autocomplete="off"></el-input>
        </el-form-item>
        <!-- <el-form-item> -->
        <!-- <el-button type="primary" @click="submitForm('ruleForm')">提交</el-button>
          <el-button @click="resetForm('ruleForm')">重置</el-button> -->
        <!-- </el-form-item> -->
      </el-form>
      <span slot="footer" class="dialog-footer">
        <el-button @click="dialogVisible = false">取 消</el-button>
        <el-button type="primary" @click="submitForm">确 定</el-button>
      </span>
    </el-dialog>
  </div>
</template>

<script>
export default {
  data() {
    return {
      dialogVisible: false,
      ruleForm: {
          username:'admin',
          password:'123'
      },
    };
  },
  methods: {
    submitForm() {
            //   console.log(this.ruleForm);
    this.$http.post('http://192.168.43.121:8080/login',this.ruleForm).then((response) => {
    console.log(response.data)
    })
    //   this.dialogVisible = false;
    },
  },
};
</script>

<style lang="less" scoped >
.header {
  text-align: center;
}
</style>> 
