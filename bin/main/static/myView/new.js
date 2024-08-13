import {$post} from "./ajax.js";

const event = (data) => {
	let list = JSON.parse(data.response);
	location.href = `/myView/detail/${list.no}`;
}

let btn = document.getElementsByTagName("button")[0];
console.log(btn);
btn.onclick = (e) => {
	let param = {
		title : document.getElementById("title").value,
		content : document.getElementById("content").value
	}
	if(param.title != "" || param.content != ""){
		console.log(param);
		$post(`/myView/new/${param.title}/${param.content}`, {}, event);
	}else{
		alert("값이 비었습니다.");
	}
}