import axios from "axios";
import dot from "dotenv";
dot.config();
const url = import.meta.env.VITE_APP_BACKEND;
axios.defaults.headers.post["Access-Control-Allow-Origin"] = import.meta.env.VITE_APP_FRONTEND;
axios.defaults.headers.get["Access-Control-Allow-Origin"] = import.meta.env.VITE_APP_FRONTEND;
// const url = import.meta.env.REACT_APP_BACKEND;
// axios.defaults.headers.post["Access-Control-Allow-Origin"] = import.meta.env.REACT_APP_FRONTEND;
// axios.defaults.headers.get["Access-Control-Allow-Origin"] = import.meta.env.REACT_APP_FRONTEND;
axios.defaults.headers.post["Content-Type"] = "application/json";

/**
 * 채팅방 목록 가져오기
 * @returns object | exception
 */
export function allChatRoom() {
	return axios.get(url + "/api/get/chatroomList");
}
