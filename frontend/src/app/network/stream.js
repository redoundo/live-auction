import Hls from "hls.js";

export function HlsForVideo() {
	if (Hls.isSupported() === false) return;
	const video = document.getElementById("video");
	const hls = new Hls();
	hls.loadSource(video.getAttribute("src"));
	hls.attachMedia(video);
	hls.on(Hls.Events.MANIFEST_PARSED, () => video.play());
}
