import { Injectable } from '@angular/core';
import { HttpRequest, HttpHandler, HttpEvent, HttpInterceptor } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { Router } from '@angular/router';


@Injectable()
export class ErrorInterceptor implements HttpInterceptor {

    constructor(private router: Router) { 
    }

    intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {

        return next.handle(request).pipe(catchError(err => {
            if ([401, 403].indexOf(err.status) !== -1) {
                // auto logout if 401 Unauthorized or 403 Forbidden response returned from api

                // Remove token and all relative informations from local storage to log user out
                window.localStorage.removeItem('token');
                window.localStorage.removeItem('username');

                this.router.navigate(['login']/*, { queryParams: { returnUrl: this.state.snapshot.url } }*/);
            }

            const error = err.error.message || err.statusText;
            return throwError(error);
        }))
    }
}