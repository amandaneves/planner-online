import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { NotificationsComponent } from './pages/notifications/notifications.component';
import { DashboardComponent } from './pages/dashboard/dashboard.component';
import { FormsComponent } from './pages/forms/forms.component';
import { TablesComponent } from './pages/tables/tables.component';
import { TypographyComponent } from './pages/typography/typography.component';
import { MapsComponent } from './pages/maps/maps.component';
import { CategoriasComponent } from './tarefas/categorias/categorias.component';

const routes: Routes = [
  { path: '', pathMatch: 'full', redirectTo: 'tarefas' },
  {
    path: 'tarefas',
    loadChildren: () => import('./tarefas/tarefas.module').then(m => m.TarefasModule)
  },
  { path: 'categorias', component: CategoriasComponent },
  { path: 'dashboard', component: DashboardComponent },
  { path: 'forms', component: FormsComponent },
  { path: 'tables', component: TablesComponent },
  { path: 'typography', component: TypographyComponent },
  { path: 'maps', component: MapsComponent },
  { path: 'notifications', component: NotificationsComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
