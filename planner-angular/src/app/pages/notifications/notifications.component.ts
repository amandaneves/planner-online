import { NgbTooltipModule } from '@ng-bootstrap/ng-bootstrap';
import { Component, OnDestroy } from '@angular/core';

import { ToastService } from './toast-service';
import { ToastsContainer } from './toasts-container';

@Component({
  selector: 'app-notifications',
  standalone: true,
	imports: [NgbTooltipModule, ToastsContainer],
  templateUrl: './notifications.component.html',
  styleUrls: ['./notifications.component.scss']
})
export class NotificationsComponent implements OnDestroy {

  constructor(public toastService: ToastService) { }

  showStandard() {
		this.toastService.show('I am a standard toast');
	}

  showSuccess() {
    this.toastService.show('I am a success toast', { classname: 'bg-success text-light', delay: 10000 });
  }

  showError() {
		this.toastService.show('Teste', { classname: 'bg-danger text-light', delay: 15000 });
	}

  showToast(dangerTpl: any) {
		this.toastService.show(dangerTpl, { classname: 'bg-danger text-light', delay: 15000 });
	}

  ngOnDestroy(): void {
		this.toastService.clear();
	}
}
