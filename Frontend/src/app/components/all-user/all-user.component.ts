import { Component } from '@angular/core';
import {UserService} from "../../services/user.service";
import {of} from "rxjs";

@Component({
  selector: 'app-all-user',
  templateUrl: './all-user.component.html',
  styleUrl: './all-user.component.css'
})
export class AllUserComponent {

  users: any =[];
  constructor(private userService:UserService) {}

  ngOnInit(){
    this.getAllUsers();
  }
  getAllUsers(){
    this.userService.getAllUsers().subscribe( res=>{
      this.users=res;
    })
  }

  deleteUser(id: any){
    this.userService.deleteUser(id).subscribe((res)=> {
      console.log(res);
      this.getAllUsers();
    })
  }

}



