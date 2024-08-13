import {$post, $get} from "./ajax.js";

const draw = (data) => {
	if(data != null){
		let list = JSON.parse(data.response);
		let html = "";
		for(let row of list){
			//console.log(row);
			html = `<a class="list-group-item m-1 ${(row.accept)? "bg-success":"bg-warning"} display-6" href="detail.html">
					${row.title}
					</a>` + html;			
		}
		document.getElementById("list").innerHTML = html;
	}	
};

const getData = (url, param) => {
	$post(url, param, draw);
};

let btns = document.getElementsByClassName("btn");
for(let i = 0; i < btns.length; i++){
	btns[i].onclick = (e) => {
		switch(i){
			case 0:
				getData("/myView/findList", {});
				break;
			case 1:
				getData("/myView/findList/1", {});
				break;
			case 2:
				getData("/myView/findList/0", {});
				break;
			case 3:
				location.href = "/myView/new";
				break;
			default:
				getData("/myView/findList", {});
				break;
		}		
	}
}
getData("/myView/findList", {});


