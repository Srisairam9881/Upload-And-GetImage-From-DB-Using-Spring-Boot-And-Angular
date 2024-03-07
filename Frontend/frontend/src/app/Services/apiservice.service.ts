import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
@Injectable({
providedIn: 'root'
})
export class ApiserviceService {
private baseUrl = 'http://localhost:8080';

constructor(private http: HttpClient) { }

uploadImage(formData: FormData){
return this.http.post(`${this.baseUrl}/upload-image`, formData);
}

getImages(){
return this.http.get(`${this.baseUrl}/images`);
}
getImageById(id:any){
return this.http.get(`t${this.baseUrl}/images/${id}`);
}
}
