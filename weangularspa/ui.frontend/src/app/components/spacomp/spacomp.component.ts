import { Component, OnInit,Input } from '@angular/core';
import { MapTo } from '@adobe/aem-angular-editable-components';

const SpacompComponentEditConfig = {
  emptyLabel: 'Spa Component',
  isEmpty: cqModel =>
    !cqModel || !cqModel.title || cqModel.title.trim().length < 1
};


@Component({
  selector: 'app-spacomp',
  templateUrl: './spacomp.component.html',
  styleUrls: ['./spacomp.component.css']
})
export class SpacompComponent implements OnInit {

  constructor() { }
  @Input() title:string;
  @Input() enableTitle:boolean

  ngOnInit(): void {
  }

}
MapTo('weangularspa/components/spacomp')(SpacompComponent, SpacompComponentEditConfig);