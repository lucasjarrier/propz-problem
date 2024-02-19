<template>
  <div class="container">
    <!-- Card 1 -->
    <el-row justify="center" style="margin-top: 20px;">
      <el-col :span="20">
        <el-card class="card">
          <div class="card-header">
            <b class="primary-color">1. Possibility of checking whether a number that the user enters is a PERFECT NUMBER</b>
          </div>
          <el-form ref="form1" :model="form1" label-width="120px">
            <el-form-item label="Number:">
              <el-input v-model.number="form1.number" placeholder="Enter a number"></el-input>
            </el-form-item>
          </el-form>
          <el-button @click="checkNumber" type="primary">Verify</el-button>
          <div class="result">{{ result1 }}</div>
        </el-card>
      </el-col>
    </el-row>

    <!-- Card 2 -->
    <el-row justify="center" style="margin-top: 20px;">
      <el-col :span="20">
        <el-card class="card">
          <div class="card-header">
            <b class="primary-color">2. Find all PERFECT NUMBERS between 2 given numbers in the interface by the user</b>
          </div>
          <el-form ref="form2" :model="form2" label-width="120px">
            <el-form-item label="Number 1:">
              <el-input v-model.number="form2.firstNumber" placeholder="Enter the first number"></el-input>
            </el-form-item>
            <el-form-item label="Number 2:">
              <el-input v-model.number="form2.secondNumber" placeholder="Enter the second number"></el-input>
            </el-form-item>
          </el-form>
          <el-button @click="findPerfectNumbers" type="primary">Find</el-button>
          <div class="result"> {{ result2 }}</div>
        </el-card>
      </el-col>
    </el-row>
  </div>
</template>

<script>
import { ElCard, ElRow, ElCol, ElForm, ElFormItem, ElInput, ElButton } from 'element-plus';
import { checkPerfectNumber, findPerfectNumbers } from '@/services/problemService';

export default {
  components: {
    ElCard,
    ElRow,
    ElCol,
    ElForm,
    ElFormItem,
    ElInput,
    ElButton
  },
  data() {
    return {
      form1: {
        number: ''
      },
      form2: {
        firstNumber: '',
        secondNumber: ''
      },
      result1: '',
      result2: ''
    };
  },
  methods: {
    async checkNumber() {
      try {
        const response = await checkPerfectNumber(this.form1.number);
        if (response.data.status == 200) {
          this.result1 = response.data.data;
        } else {
          this.result1 = response.data.message;
        }
      } catch (error) {
        this.result1 = 'Error' + error;
      }
    },
    async findPerfectNumbers() {
      try {
        const response = await findPerfectNumbers(this.form2.firstNumber, this.form2.secondNumber);
        if (response.data.status == 200) {
          this.result2 = response.data.data;
        } else {
          this.result2 = response.data.message;
        }
      } catch (error) {
        this.result2 = 'Error' + error;
      }
    }
  }
};
</script>

<style scoped>
.container {
  margin-left: auto;
  margin-right: auto;
}

.card {
  width: 100%;
}

.card-header {
  padding: 10px;
  background-color: #f0f0f0;
  font-weight: bold;
}

.el-card__body {
  padding-bottom: 20px;
}

.el-form-item {
  margin: 2%;
}

.el-button {
  margin-bottom: 2%;
  float: right;
}

.result {
  margin-top: 20px;
}
</style>
