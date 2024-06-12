import { createStompClient } from "../network/stomp";
import { useEffect, useState } from "react";
import { useLocation } from "react-router-dom";

export function ChattingRoom() {
	const chatRoom = useLocation().state;
	let [client, setClient] = useState(null);

	useEffect(() => {
		if ((client ?? null) === null) {
			const stomp = createStompClient({ roomId: chatRoom["roomId"] });
			setClient(stomp);
		}
	}, [chatRoom, client]);
}
