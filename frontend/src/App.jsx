import { MainPage } from "./app/MainPage";
import { ChattingRoom } from "./app/chatroom/ChattingTemplate";
import { Route, Routes } from "react-router-dom";
import "./App.css";

function App() {
	return (
		<Routes>
			<Route path="/" element={<MainPage />} />
			<Route path="/chat/:roomId" element={<ChattingRoom />} />
		</Routes>
	);
}

export default App;
