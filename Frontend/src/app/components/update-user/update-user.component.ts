import { Component } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {UserService} from "../../services/user.service";
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-update-user',
  templateUrl: './update-user.component.html',
  styleUrl: './update-user.component.css'
})
export class UpdateUserComponent {


  validateForm!: FormGroup;
  id: any = this.activatedRoute.snapshot.params['id']

  constructor(private userService: UserService,
              private fb: FormBuilder,
              private activatedRoute: ActivatedRoute) { }

  ngOnInit() {
    this.validateForm = this.fb.group({
      name: [null, [Validators.required]],
      email: [null, [Validators.email, Validators.required]]
    })
    this.getUserById();
  }

  getUserById() {
    this.userService.getUserById(this.id).subscribe((res) => {
      console.log(res);
      this.validateForm.patchValue(res);
    })
  }

  updateUser() {
    this.userService.updateUser(this.id, this.validateForm.value).subscribe(res => {
      console.log(res)
    })
  }

}
