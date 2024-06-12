import { Stomp } from "@stomp/stompjs";

export function createStompClient({ roomId }) {
	const socket = new WebSocket("ws://localhost:8080/chat_stomp");
	const client = Stomp.over(socket);
	client.connect({}, function (frame) {
		console.log("Connected: " + frame);
		client.subscribe("/send/" + roomId, function (message) {
			console.log(message.body);
		});
	});
	return client;
}
