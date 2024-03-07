import { Component, OnInit } from '@angular/core';
import { ApiserviceService } from 'src/app/Services/apiservice.service';

@Component({
selector: 'app-image-list',
templateUrl: './image-list.component.html',
styleUrls: ['./image-list.component.css']
})
export class ImageListComponent implements OnInit {

images!: any[];

constructor(private apiService: ApiserviceService) { }

ngOnInit(): void {
this.apiService.getImages().subscribe(
(data: any) => { // Specify the type of the 'data' parameter as 'any[]'
this.images = data;
},
error => {
console.error('Error fetching images:', error);
}
);
}

getImageUrl(id: number): string {
return `http://localhost:8080/images/${id}`;
}
}
