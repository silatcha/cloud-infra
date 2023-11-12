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
    
        this.planingService.addMatter({
          matterId: 0,
          name: 'Cloud data',
          coef: 3,
          teachers: [],
          speciality: []
        }).subscribe(user => {
          this.planingService.addSpecialities({
            specialityId: 0,
            name: 'ICC',
            groupSize: 22
          },user.matterId).subscribe(user => {
      
          }, (err: any) => {
              console.error(err);
            
          })

          this.planingService.addTeacher({
            teacherId: 0,
            firstName: 'Kotti',
            email: 'kotti@email.com',
            phone: 0,
            lastName: 'cytech',
            password: 'cool',
            role: 'teacher'
          },user.matterId).subscribe(user => {
      
          }, (err: any) => {
              console.error(err);
            
          })

        }, (err: any) => {
            console.error(err);
          
        })
        this.planingService.getSpecialities().subscribe(speciality=>{

          this.planingService.addMatter({
            matterId: 0,
            name: 'Micro Service',
            coef: 3,
            teachers: [],
            speciality: [speciality[0]]
          }).subscribe(user => {
            this.planingService.addTeacher({
              teacherId: 0,
              firstName: 'Lucas',
              email: 'lucas@email.com',
              phone: 0,
              lastName: 'cytech',
              password: 'cool',
              role: 'teacher'
            },user.matterId).subscribe(user => {
        
            }, (err: any) => {
                console.error(err);
              
            })
          }, (err: any) => {
              console.error(err);
            
          })
      
          this.planingService.addMatter({
            matterId: 0,
            name: 'Rust',
            coef: 3,
            teachers: [],
            speciality: [speciality[0]]
          }).subscribe(user => {
      

            this.planingService.addTeacher({
              teacherId: 0,
              firstName: 'Damien',
              email: 'damien@email.com',
              phone: 0,
              lastName: 'cytech',
              password: 'cool',
              role: 'teacher'
            },user.matterId).subscribe(user => {
        
            }, (err: any) => {
                console.error(err);
              
            })

          }, (err: any) => {
              console.error(err);
            
          })
      
          this.planingService.addMatter({
            matterId: 0,
            name: 'Cloud Infrastructure',
            coef: 3,
            teachers: [],
            speciality: [speciality[0]]
          }).subscribe(user => {
      

            this.planingService.addTeacher({
              teacherId: 0,
              firstName: 'Juan',
              email: 'juan@email.com',
              phone: 0,
              lastName: 'cytech',
              password: 'cool',
              role: 'teacher'
            },user.matterId).subscribe(user => {
        
            }, (err: any) => {
                console.error(err);
              
            })


          }, (err: any) => {
              console.error(err);
            
          })
      
          
        })
        
    

        this.planingService.addRoom({
          roomId: 0,
          name: 'Amphi',
          capacity: 500,
          state: false
        }).subscribe(user => {
        
        }, (err: any) => {
            console.error(err);
          
        })
        
        this.planingService.addRoom({
          roomId: 0,
          name: 'E100',
          capacity: 35,
          state: false
        }).subscribe(user => {
        
        }, (err: any) => {
            console.error(err);
          
        })
        
        this.planingService.addRoom({
          roomId: 0,
          name: 'E109',
          capacity: 35,
          state: false
        }).subscribe(user => {
        
        }, (err: any) => {
            console.error(err);
          
        })

        this.planingService.addRoom({
          roomId: 0,
          name: 'E211',
          capacity: 90,
          state: false
        }).subscribe(user => {
        
        }, (err: any) => {
            console.error(err);
          
        })
    
      }

     })

      
  }
  
  logout(){
    sessionStorage.clear();
    window.location.reload();
  }
}
