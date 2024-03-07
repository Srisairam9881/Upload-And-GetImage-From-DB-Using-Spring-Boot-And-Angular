import { Component } from '@angular/core';
import { ApiserviceService } from 'src/app/Services/apiservice.service';

@Component({
selector: 'app-upload',
templateUrl: './upload.component.html',
styleUrls: ['./upload.component.css']
})
export class UploadComponent {

selectedFile!: File;

constructor(private apiService: ApiserviceService) { }

onFileSelected(event:any): void {
this.selectedFile = event.target.files[0];
}

onSubmit(): void {
const formData = new FormData();
formData.append('data', this.selectedFile); // Use 'data' as the key
this.apiService.uploadImage(formData).subscribe(
response => {
console.log('Image uploaded successfully');
},
error => {
console.error('Error uploading image:', error);
}
);
}
}
