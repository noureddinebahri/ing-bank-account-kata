import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, Router } from '@angular/router';
//import { ApiService } from "../core/api.service";

@Injectable()
export class AuthenticationGuardService implements CanActivate {

    constructor(
        //private apiService: ApiService,
        private router: Router) {
    }

    canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): boolean {

        const token = window.localStorage.getItem('token');

//        if (typeof (token) == "undefined" || token == null || token == '') {
//
//            this.router.navigate(['login'], { queryParams: { returnUrl: state.url } });
//            return false;
//
//        } else {
//
            return true;
//        }
    }
}
