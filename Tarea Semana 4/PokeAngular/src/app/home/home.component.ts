import { Component, OnInit, ViewChild, ElementRef } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  @ViewChild("videoPlayer", { static: false }) videoplayer!: ElementRef;
  isMuted: boolean = true;

  constructor() {}

  ngOnInit(): void {
    // this.videoplayer.nativeElement.play();
  }

  toggleMute(): void {
    this.isMuted = !this.isMuted;
  }
}
