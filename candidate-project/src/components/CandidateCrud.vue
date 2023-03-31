<template>
 <div class="container">
  <div class="row">
    <div class="col-md-12">
      <h2>Applicant Tracking</h2>

      <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal">
  Candidate Add
</button>

<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">

      <div class="modal-header">
        <h5 class="modal-title text-danger" id="exampleModalLabel">Candidate Form</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
<form @submit.prevent="save">
  <div class="form-group">
    <label>Candidate Name</label>
    <input type="text" v-model="candidate.candidateFullName" class="form-control"  placeholder="Candidate FullName">
  
  </div>
  <div class="form-group">
    <label>Job Role </label>
    <input type="text" v-model="candidate.jobRole" class="form-control"  placeholder="Job Role">
  
  </div>
  <div class="form-group">
    <label>Email</label>
    
    <input type="email" v-model="candidate.email" class="form-control"  placeholder="Email">
  
  </div>
  <div class="form-group">

    <label>Location</label>
    
    <input type="text" v-model="candidate.location" class="form-control"  placeholder="Location">
  
  </div>

  <div class="form-group">
    <div class="col-sm-10">
    <label for="status">Candidate Statu *</label>
    <select class="form-control"> 
    <option value="">Select Candidate Statu</option>
    <option v-for="candidate in result" :key="candidate.id" value="item.id">{{candidate.candidateStatu}}</option>
</select>
  </div>
</div>

  <button type="submit" class="btn btn-primary">Save</button>
</form>
</div>
</div>
</div>
</div>

      <h2>Candidate List</h2>
      <table class="table table-dark">
  <thead>
    <tr>
      <th scope="col">Candidate Name</th>
      <th scope="col">Job Role</th>
      <th scope="col">Email</th>
      <th scope="col">Location</th>
      <th scope="col">Candidate Statu</th>
    </tr>
  </thead>
  <tbody>
    <tr v-for="candidate in result" v-bind:key="candidate.id">
          
          <td>{{ candidate.candidateFullName }}</td>
          <td>{{ candidate.jobRole }}</td>
          <td>{{ candidate.email }}</td>
          <td>{{ candidate.location }}</td>
          <td>{{ candidate.candidateStatu }}</td>
          <td>
            <button type="button" class="btn btn-warning" @click="edit(candidate)">Edit</button>
            <button type="button" class="btn btn-danger"  @click="remove(candidate)">Delete</button>
          </td>
        </tr>
    
  </tbody>
</table>
    
 
    </div>
  </div>
 </div>

  
</template>
  
  <script>
    import Vue from 'vue';
    import axios from 'axios';
    import "bootstrap/dist/css/bootstrap.min.css";
    import "bootstrap/dist/js/bootstrap.min.js";
     Vue.use(axios)
  export default {
    name: 'CandidateCrud',
    data () {
      return {
        result: {},
 
        candidate:{
            candidateId: '',
            candidateFullName: '',
            jobRole: '',
            email: '',
            location: '',
            candidateStatu: ''
        }
      }
    },
    created() {
        this.CandidateLoad();
    },
    mounted() {
          console.log("mounted() called.......");
        
      },
    methods: {
        CandidateLoad()
           {
                 var page = "http://localhost:8080/candidates";
                 axios.get(page)
                  .then(
                      ({data})=>{
                        console.log(data);
                        this.result = data;
                      }
                  );
           },
          
          
           save()
           {
            if(this.candidate.candidateId == '')
              {
                this.saveData();
              }
              else
              {
                this.updateData();
              }      
           },
           saveData()
           {
            axios.post("http://localhost:8080/candidates", this.candidate)
            .then(
              ({data})=>{
                alert("save successful");
                this.candidate.candidateId = '';
                this.candidate.candidateFullName = '';
                this.candidate.jobRole = '',
                this.candidate.email = '',
                this.candidate.location = '',
                this.candidate.candidateStatu = ''

                this.CandidateLoad();
              }
            )
           },
           edit(candidate)
           {
            this.candidate = candidate;
          
           },
           updateData()
           {
              var editrecords = 'http://localhost:8080/candidates';
              axios.put(editrecords, this.candidate)
              .then(
                ({data})=>{
                    this.candidate.candidateId = '';
                this.candidate.candidateFullName = '';
                this.candidate.jobRole = '',
                this.candidate.email = '',
                this.candidate.location = '',
                this.candidate.candidateStatu = ''
                  alert("Updated!!!");
                  this.CandidateLoad();
                }
              );
           },
           remove(candidate){
             var url = `http://localhost:8080/candidates/${candidate.candidateId}`;
              axios.delete(url);
              alert("Deleteddd");
              this.CandidateLoad();
            }
      }
  }
  </script>