import { Component } from '@angular/core';
import { Manager } from './type/types';
import { PlaningService } from './service/planing.service';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'planing-lib';
  private cache: Array<number>=[0]

  role=sessionStorage.getItem("role");
  
    user=sessionStorage.getItem('user');
    userObject=this.user ? JSON.parse(this.user) :""
    
    constructor(private planingService: PlaningService) {
     
     }

     ngOnInit(): void {

      console.log("taille cashe ",this.cache.length)

        
     console.log("entre dans le of")

     this.planingService.getManager().subscribe(manager=>{

      if(manager.length<1){

        this.planingService.addManager({
          managerId: 1,
          firstName: "admin",
          email: "admin@email.com",
          lastName: "manager",
          password: "cool",
          role: "manager",
          phone: 0
        }).subscribe(user => {
    
        }, (err: any) => {
            console.error(err);
          
        })

     this.planingService.addTeacher({
       teacherId: 0,
       firstName: '',
       email: '',
       phone: 0,
       lastName: '',
       password: '',
       role: ''
     },1)
     


        this.planingService.addMatter({
          matterId: 0,
          name: 'Cloud data',
          coef: 3,
          teachers: [],
          speciality: []
        }).subscribe(user => {
    
        }, (err: any) => {
            console.error(err);
          
        })

        this.planingService.addMatter({
          matterId: 0,
          name: 'Micro Service',
          coef: 3,
          teachers: [],
          speciality: []
        }).subscribe(user => {
    
        }, (err: any) => {
            console.error(err);
          
        })
    
        this.planingService.addMatter({
          matterId: 0,
          name: 'Rust',
          coef: 3,
          teachers: [],
          speciality: []
        }).subscribe(user => {
    
        }, (err: any) => {
            console.error(err);
          
        })
    
        this.planingService.addMatter({
          matterId: 0,
          name: 'Cloud Infrastructure',
          coef: 3,
          teachers: [],
          speciality: []
        }).subscribe(user => {
    
        }, (err: any) => {
            console.error(err);
          
        })

        this.planingService.addSpecialities({
          specialityId: 0,
          name: 'ICC',
          groupSize: 22
        },1).subscribe(speciality => {
        }, (err: any) => {
            console.error(err);
          
        })
    
        this.planingService.addTeacher({
          teacherId: 0,
          firstName: 'Damien',
          email: 'teacher@prof.com',
          phone: 0,
          lastName: 'cytech',
          password: 'cool',
          role: 'teacher'
        },1)

        this.planingService.addTeacher({
          teacherId: 0,
          firstName: 'Juan',
          email: 'teacher@prof.com',
          phone: 0,
          lastName: 'cytech',
          password: 'cool',
          role: 'teacher'
        },2)
    

        
    
      }

     })

      
  }
  
  logout(){
    sessionStorage.clear();
    window.location.reload();
  }
}
