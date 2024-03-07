import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { UploadComponent } from './components/upload/upload.component';
import { ImageListComponent } from './components/image-list/image-list.component';

const routes: Routes = [
{path:'',component:UploadComponent,pathMatch:"full"},
{path:'all-images',component:ImageListComponent},
{path:'upload-images',component:UploadComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
