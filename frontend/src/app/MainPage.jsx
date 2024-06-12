import { useEffect } from "react";
import { allChatRoom } from "./network/rest";
import { useState } from "react";
import { Link } from "react-router-dom";

export function MainPage() {
	let [chatRooms, setChatRooms] = useState([]);

	useEffect(() => {
		getChatRoomList();
	}, []);

	const getChatRoomList = async () => {
		await allChatRoom()
			.then((val) => {
				console.log(val?.data);
				if ((val?.data ?? null) !== null) setChatRooms(val.data);
			})
			.catch((err) => console.log(`MainPage's getChatRoomList function error:  ${err}`));
	};
	return (
		<div className="main">
			<div className="chatRoomList">
				{chatRooms.map((chatRoom) => {
					return <ChatRoomFormat key={chatRoom["roomId"]} chatRoom={chatRoom} />;
				})}
			</div>
		</div>
	);
}

export function ChatRoomFormat(chatRoom) {
	return (
		<div className="chatRooms">
			<div className="streaming-video">
				<Link to={"/chat/" + chatRoom["roomId"]} state={chatRoom}>
					<img className="streaming-video-img" src="../public/8BZ1706581862318-850.jpg" />
				</Link>
			</div>
			<div className="chatRoomInfo">
				<div className="speaker-info">
					<div className="speaker-img"></div>
					<div className="info-detail">
						<Link to={"/chat/" + chatRoom["roomId"]} state={chatRoom}>
							{chatRoom["roomName"]}
							<div className="speaker-name">{chatRoom["speaker"]}</div>
						</Link>
					</div>
				</div>
			</div>
		</div>
	);
}
